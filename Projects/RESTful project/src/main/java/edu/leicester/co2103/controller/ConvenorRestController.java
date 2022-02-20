package edu.leicester.co2103.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import edu.leicester.co2103.domain.Convenor;
import edu.leicester.co2103.domain.ErrorInfo;
import edu.leicester.co2103.repo.ConvenorRepository;
import edu.leicester.co2103.repo.ModuleRepository;



@RestController
@RequestMapping("/convenors")
public class ConvenorRestController {
	
	@Autowired
	ConvenorRepository repo;	
	
	@Autowired
	ModuleRepository repom;
	
	@GetMapping()
	public ResponseEntity<List<Convenor>> listAllConvenors() { 
	  List<Convenor> convenors = repo.findAll(); 
	  if (convenors.isEmpty()) { 
	    return new ResponseEntity<List<Convenor>>(HttpStatus.BAD_REQUEST); 
	  } 
	  return new ResponseEntity<List<Convenor>>(convenors, HttpStatus.OK); 
	} 
	
	@PostMapping() 
	public ResponseEntity<?> createConvenor(@RequestBody Convenor newConvenor, UriComponentsBuilder ucBuilder) {
			if(newConvenor.getName().isEmpty()) {
				 return new ResponseEntity<ErrorInfo>(new ErrorInfo("The Convenors name is empty."), HttpStatus.BAD_REQUEST);
	  } 
	  repo.save(newConvenor); 
	  HttpHeaders headers = new HttpHeaders(); 
	  headers.setLocation(ucBuilder.path("/convenors/{id}").buildAndExpand(newConvenor.getId()).toUri()); 
	  return new ResponseEntity<String>(headers, HttpStatus.CREATED); 
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getConvenor(@PathVariable("id") long id){
		Convenor convenor = repo.findById(id).orElse(null);
		if (convenor == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Convenor with id " + id + " not found"), HttpStatus.NOT_FOUND); 
		  } 
		 return new ResponseEntity<Convenor>(convenor, HttpStatus.OK); 
		}
	
	@PutMapping("/{id}") 
	public ResponseEntity<?> updateConvenor(@PathVariable("id") long id, @RequestBody Convenor newConvenor) { 
	  Convenor currentConvenor = repo.findById(id).orElse(null);
	  if (currentConvenor == null) { 
	    return new ResponseEntity<ErrorInfo>(new ErrorInfo("Convenor with id " + id + " not found."), HttpStatus.NOT_FOUND); 
	  } 
	  currentConvenor.setName(newConvenor.getName()); 
	  currentConvenor.setPosition(newConvenor.getPosition()); 
	  repo.save(currentConvenor);
	  return new ResponseEntity<Convenor>(currentConvenor, HttpStatus.OK); 
}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> deleteConvenor(@PathVariable("id") long id){
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
				return new ResponseEntity<Convenor>(HttpStatus.OK);
		} 
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Convenor with id " + id + " not found."), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/modules")
	public ResponseEntity<?> getConvenorModules(@PathVariable("id") long id){
		Convenor convenor = repo.findById(id).orElse(null);
		if (convenor == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Convenor with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(convenor.getModules(), HttpStatus.OK);
	}
}

