package edu.leicester.co2103.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.leicester.co2103.repo.ConvenorRepository;
import edu.leicester.co2103.repo.ModuleRepository;
import edu.leicester.co2103.repo.SessionRepository;
import edu.leicester.co2103.domain.ErrorInfo;
import edu.leicester.co2103.domain.Session;
import edu.leicester.co2103.domain.Module;
import edu.leicester.co2103.domain.Convenor;

@RestController
@RequestMapping("/sessions")
public class SessionRestController {
	
	@Autowired
	SessionRepository repo;
	
	@Autowired
	ModuleRepository repoM;
	
	@Autowired
	ConvenorRepository repoC;
	
	@DeleteMapping()
	public ResponseEntity<?> deleteSessions(){
		List<Session> sessions = repo.findAll();
		if (sessions.isEmpty()) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("There are no sessions to delete."), HttpStatus.BAD_REQUEST);
		}else
		repo.deleteAll(sessions);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<?> filterSession(@RequestParam (required = false) String module, @RequestParam (required = false) Long convenor) {
		
		List<Module> modules = repoM.findAll();
		List<Convenor> convenors = repoC.findAll();
		List<Session> sessions = new ArrayList<>();
		
		if (convenor != null && module == null) {
			for(Convenor c: convenors) {
				if(c.getId() == convenor) {
					for(Module m : modules) {
						if(c.getModules().contains(m)) {
							sessions.addAll(m.getSessions());
							if (sessions.size() == c.getModules().size()) {
								return new ResponseEntity<>(sessions, HttpStatus.OK);
							}else {
							continue;
							}
						}
						
					}
							
						}
				
						}
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Convenor with ID " + convenor + " not found"),HttpStatus.NOT_FOUND);
					}
					
					

		if (!module.isEmpty() && convenor == null) {
			for (Module m : modules) {
				if (m.getCode().equals(module)) {
				return new ResponseEntity<>(m.getSessions(), HttpStatus.OK);
				}			
			}
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + module + " not found"),HttpStatus.NOT_FOUND);
		} 
		
	if (!module.isEmpty() && convenor != null) {
		for (Convenor c : convenors) {
			for (Module m : modules) {
			if (c.getId() == convenor && m.getCode().equals(module)) {
						return new ResponseEntity<>(m.getSessions(), HttpStatus.OK);
				}
				}
			}
		}
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Convenor or module is incorrect and not found"), HttpStatus.NOT_FOUND);
	}
}
