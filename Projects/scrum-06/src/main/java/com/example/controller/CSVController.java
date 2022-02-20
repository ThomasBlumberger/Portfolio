package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Convenor;
import com.example.domain.Groupwork;
import com.example.domain.ResetRequest;
import com.example.domain.Student;
import com.example.repository.ConvenorRepository;
import com.example.repository.GroupworkRepository;
import com.example.repository.ResetRequestRepository;
import com.example.repository.StudentRepository;
import com.opencsv.CSVReader;

@Controller
public class CSVController {
	
	@Autowired
	private GroupworkRepository Crepo;
	
	@Autowired
	private ConvenorRepository crepo;
	
	@Autowired
	private StudentRepository srepo;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private ResetRequestRepository rr;
	
	@GetMapping(value = "/uploadCSV")
	public String uploadCSVPage(@RequestParam Integer groupworkId, Model model, Principal principal) {
		Convenor u = crepo.findByUsername(principal.getName());
		model.addAttribute("user", u.getName());
		
		model.addAttribute("groupworkId", groupworkId);
		return "convenor/csv";
	}
	
	@RequestMapping("/download/xlsx/{filename:.+}")
	public void downloadXlsxResource ( HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String fileName) {
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/xlsx/");
		Path file = Paths.get(dataDirectory, fileName);
		
		if (Files.exists(file)) {
			response.setContentType("application/xlsx");
			response.addHeader("Content-Disposition", "attachment; filename="+fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			}
			catch (IOException ex) {
			ex.printStackTrace();
			}
		}
		
	}
	
	
	@PostMapping("/upload")
    public String singleFileUpload(@RequestParam("groupworkId") int groupworkId, @RequestParam("file") MultipartFile file, Model model, Principal principal) {
		Convenor u = crepo.findByUsername(principal.getName());
		Groupwork targetGroupwork = Crepo.findById(groupworkId);
		
		if (targetGroupwork == null || targetGroupwork.getAuthor() != u){
			return "security/denied";
		}
		
		model.addAttribute("user", u.getName());
		
		String fileName = file.getOriginalFilename();

 		File convertedFile = new File(file.getOriginalFilename());
		List<List<String>> records = new ArrayList<List<String>>();
		
        if (!file.isEmpty()) {
        	 try {
             	if (FilenameUtils.getExtension(fileName).equals("csv"))
             	{
             		convertedFile.createNewFile();
             		FileOutputStream fos = new FileOutputStream(convertedFile);
             		fos.write(file.getBytes());
             		fos.close();
             		
             		
             		try (CSVReader csvReader = new CSVReader(new FileReader(convertedFile));) {
             		    String[] values = null;
             		    while ((values = csvReader.readNext()) != null) {
             		        records.add(Arrays.asList(values));
             		    }
             		}
             	}	
             	else if (FilenameUtils.getExtension(fileName).equals("xlsx")) {
             		
             		convertedFile.createNewFile();
             		FileOutputStream fos = new FileOutputStream(convertedFile);
             		fos.write(file.getBytes());
             		fos.close();
             		
             		
             		FileInputStream fileInStream = new FileInputStream(convertedFile);
             		 
                    XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
                    XSSFSheet selSheet = workBook.getSheetAt(0);
             
                    
                    
                    Iterator<Row> rowIterator = selSheet.iterator();
                    while (rowIterator.hasNext()) {
             
                        Row row = rowIterator.next();
             
                        Iterator<Cell> cellIterator = row.cellIterator();
                        StringBuffer sb = new StringBuffer();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            if (sb.length() != 0) {
                                sb.append(",");
                            }
                             
                            switch (cell.getCellType()) {
                            case STRING:
                                sb.append(cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                sb.append(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                sb.append(cell.getBooleanCellValue());
                                break;
                            default:
                            }
                        }
                        
                        String lines[] = sb.toString().split("\\n");
                        for (String line : lines) {
                        	List<String> itemAttributes = Arrays.asList(line.split(","));
                        	records.add(itemAttributes);
                        }
                    }
                    workBook.close();
                    
             		
             	}
             	else {
             		model.addAttribute("status", "Uploaded file was not a csv or xlsx!");
                	model.addAttribute("groupworkId", groupworkId);
             		return "/convenor/csv";
             	}
             } catch (Exception e) {
                 System.out.println(e);
             }
        }
        
        
        if (!records.isEmpty()) {
        	records.remove(0);
        	for (List<String> record : records) {
        		Student user = srepo.findByUsername(record.get(3));
        		
        		if (user == null) {
        			user = new Student();
        			user.setUsername(record.get(3)); //Student Id
        			user.setName(record.get(2) + " " + record.get(1)); //Name
            		user.setPassword(pe.encode("1234")); //Password
            		user.setEmail(record.get(3) + "@student.le.ac.uk");
         
            		switch (record.get(4)) { 
	            		case "true":
	            			user.setAtRisk(true);
	            			break;
	            		case "1":
	            			user.setAtRisk(true);
	            			break;
	            		default:
	            			user.setAtRisk(false);
            		}
            	
            		Groupwork groupwork = Crepo.findById(groupworkId);
            		srepo.save(user); // Save student
            		groupwork.getStudents().add(user); // Add student to the groupwork
            		Crepo.save(groupwork);
            		srepo.save(user);
            		
            		try {
						user.sendConfirmationEmail(rr.save(new ResetRequest(user)));
					} catch (MessagingException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
        		}
        		else {
        			System.out.println("User already exists!");
        			Groupwork groupwork = Crepo.findById(groupworkId);
        			if (!groupwork.getStudents().contains(user)) {
        				groupwork.getStudents().add((Student) user); // Add student to the groupwork
                		Crepo.save(groupwork);
                		srepo.save(user);
        			}
        		}
        	}
        	convertedFile.delete();
        }
        
        else {
        	model.addAttribute("status","No file selected");
        	model.addAttribute("groupworkId", groupworkId);
        	return "/convenor/csv";
        }
        return "redirect:/convenor/students?groupwork=" + groupworkId;
    }
	
}
