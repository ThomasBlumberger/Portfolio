package edu.leicester.co2103.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.leicester.co2103.domain.Convenor;
import edu.leicester.co2103.domain.ErrorInfo;
import edu.leicester.co2103.domain.Module;
import edu.leicester.co2103.domain.Session;
import edu.leicester.co2103.repo.ConvenorRepository;
import edu.leicester.co2103.repo.ModuleRepository;
import edu.leicester.co2103.repo.SessionRepository;

@RestController
@RequestMapping("/modules")
public class ModuleRestController {
	
	@Autowired
	ModuleRepository repo;
	
	@Autowired
	SessionRepository repoS;
	
	@Autowired
	ConvenorRepository repoC;
	
	@GetMapping()
	public ResponseEntity<List<Module>> listAllConvenors() { 
	  List<Module> modules = repo.findAll(); 
	  if (modules.isEmpty()) { 
	    return new ResponseEntity<List<Module>>(HttpStatus.BAD_REQUEST); 
	  } 
	  return new ResponseEntity<List<Module>>(modules, HttpStatus.OK); 
	} 
	
	@PostMapping()
	public ResponseEntity<?> createModule(@RequestBody Module module, UriComponentsBuilder ucBuilder){
		if (repo.existsById(module.getCode())) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with name " + module.getCode() + " already exists."), HttpStatus.CONFLICT); 
		}
		if (module.getLevel() <1 || module.getLevel() >4) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo ("Level cannot be less than 1 or more than 4"), HttpStatus.BAD_REQUEST);
		}
		if (module.isOptional() == null) {
			module.setOptional(false);
		}
		repo.save(module);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/modules/{id}").buildAndExpand(module.getCode()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> updateModule(@PathVariable("id") String code){
		Module module = repo.findById(code).orElse(null);
		if (module == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND); 
		  } 
		 return new ResponseEntity<Module>(module, HttpStatus.OK); 
		}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> updateModule(@PathVariable("id") String code, @RequestBody Module newModule){
	Module currentModule = repo.findById(code).orElse(null);
	
	if (currentModule == null) {
		return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found."), HttpStatus.NOT_FOUND); 
	}
	if(newModule.getLevel() <0 || newModule.getLevel() >4) {
		return new ResponseEntity<ErrorInfo>(new ErrorInfo ("Level cannot be less than 1 or more than 4"), HttpStatus.BAD_REQUEST);
		}
	else if(newModule.getLevel() == 0) {
		currentModule.setLevel(currentModule.getLevel());
	}
	else if (newModule.getLevel() != null){
		currentModule.setLevel(newModule.getLevel());
		repo.save(currentModule);	
	}
	if(newModule.getTitle().isBlank()) {
		currentModule.setTitle(currentModule.getTitle());
		}
	else if (newModule.getTitle() != null) {
		currentModule.setTitle(newModule.getTitle());
		repo.save(currentModule);
	}
	
	if(newModule.isOptional() == null) {
		currentModule.setOptional(currentModule.isOptional());
	}
	else if(newModule.isOptional() != null) 
		currentModule.setOptional(newModule.isOptional());
		repo.save(currentModule);
	return new ResponseEntity<Module>(currentModule, HttpStatus.OK);
	
	}	
		

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteModule(@PathVariable("id") String code){
		Module module = repo.findById(code).orElse(null);
		List<Convenor> convenors = repoC.findAll();
		List<Module> modules = repo.findAll();
		for (Module m : modules) {
			if(m.getCode().equals(code)) {
				for (Convenor c : convenors) {
					if (c.getModules().contains(m)) {
						c.getModules().remove(m);
						continue;
					}
					repoC.save(c);
				}
				repo.delete(m);
			}
		}
		
		if (module == null) {
		return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND);
		}else
			return new ResponseEntity<Module>(HttpStatus.OK);
		}
	
	@GetMapping("/{id}/sessions")
	public ResponseEntity<?> getModuleSessions(@PathVariable("id") String code){
		Module module = repo.findById(code).orElse(null);
		if (module == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(module.getSessions(), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/sessions")
	public ResponseEntity<?> createSession(@PathVariable("id") String code, @RequestBody Session session){
		List<Module> modules = repo.findAll();
		for (Module m : modules) {
			if (m.getCode().equals(code)) {
	
				m.getSessions().add(session);
				repoS.save(session);
				
				return new ResponseEntity<Session>(session, HttpStatus.CREATED); 
			}
		}
		return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " does not exist"), HttpStatus.NOT_FOUND);
}
	
	@GetMapping("/{code}/sessions/{id}")
	public ResponseEntity<?> getSessions(@PathVariable("code") String code, @PathVariable("id") long id){
		Module module = repo.findById(code).orElse(null);
		List<Module> modules = repo.findAll();
		List<Session> sessions = repoS.findAll();
		for (Module m : modules) {
			if (m.getCode().equals(code)) {
				for (Session s : sessions) {
					if (s.getId() == id) {
						return new ResponseEntity<>(s, HttpStatus.OK);
					}
				}
				
			}
		}if (module == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND);
		}else
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Session with id " + id + " not found"), HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{code}/sessions/{id}")
	public ResponseEntity<?> updateSession(@PathVariable("code") String code, @PathVariable("id") long id, @RequestBody Session newSession){
		Module module = repo.findById(code).orElse(null);
		Session currentSession	 = repoS.findById(id).orElse(null);
		List<Module> modules = repo.findAll();
		List<Session> sessions = repoS.findAll();
		for (Module m : modules) {
			if (m.getCode().equals(code)) {
				for (Session s : sessions) {
					if (s.getId() == id) {
						currentSession.setDatetime(newSession.getDatetime());
						currentSession.setDuration(newSession.getDuration());
						currentSession.setTopic(newSession.getTopic());
						repoS.save(currentSession);
						return new ResponseEntity<Session>(currentSession, HttpStatus.OK);
					}
				}
			}
		}
		if (module == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND);
		}else
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Session with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
	
	@PatchMapping("/{code}/sessions/{id}")
	public ResponseEntity<?> partialSession(@PathVariable("code") String code, @PathVariable("id") long id, @RequestBody Session partialSession){
		Module module = repo.findById(code).orElse(null);
		Session currentSession = repoS.findById(id).orElse(null);
		List<Module> modules = repo.findAll();
		List<Session> sessions = repoS.findAll();
		for (Module m : modules) {
			if (m.getCode().equals(code)) {
				for (Session s : sessions) {
					if (s.getId() == id) {
						if (partialSession.getTopic().isBlank()) {
							currentSession.setTopic(currentSession.getTopic());
						}
							else if (partialSession.getTopic() != null) {
								currentSession.setTopic(partialSession.getTopic());
								repoS.save(currentSession);
							}
						
						if(partialSession.getDatetime() == null) {
							currentSession.setDatetime(currentSession.getDatetime());
						}
							else if (partialSession.getDatetime() != null) {
								currentSession.setDatetime(partialSession.getDatetime());
								repoS.save(currentSession);
								
							}
						if(partialSession.getDuration() == null) {
							currentSession.setDuration(currentSession.getDuration());
						}
						else if (partialSession.getDuration() != null) {
							currentSession.setDuration(partialSession.getDuration());
							repoS.save(currentSession);
							
						}
							
						}
					}
				}
			}
		if (module == null) {
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND);
		}else if (currentSession == null){
			return new ResponseEntity<ErrorInfo>(new ErrorInfo("Session with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Session>(currentSession, HttpStatus.OK);
		 
	}
	
	
	
	
	@DeleteMapping("/{code}/sessions/{id}")
	public ResponseEntity<?> deleteSession(@PathVariable("code") String code, @PathVariable("id") long id){
	Module module = repo.findById(code).orElse(null);
	List<Module> modules = repo.findAll();
	List<Session> sessions = repoS.findAll();
	for (Module m : modules) {
		if(m.getCode().equals(code)) {
			for(Session s : sessions) {
				if (s.getId() == id) {
					repoS.delete(s);
					return new ResponseEntity<>(HttpStatus.OK);
				}
			}
		}
	}
	if (module == null) {
		return new ResponseEntity<ErrorInfo>(new ErrorInfo("Module with code " + code + " not found"), HttpStatus.NOT_FOUND);
	}else
		return new ResponseEntity<ErrorInfo>(new ErrorInfo("Session with id " + id + " not found"), HttpStatus.NOT_FOUND);
}
}