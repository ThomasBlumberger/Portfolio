package co2103.hw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co2103.hw2.repo.PropertyManagerRepository;
import co2103.hw2.repo.PropertyRepository;
import co2103.hw2.repo.TenantRepository;


@Controller
public class DeleteController {

	@Autowired
	private PropertyRepository repop;
	
	@Autowired
	private PropertyManagerRepository repopm;
	
	@Autowired
	private TenantRepository repot;
	

// Things will have to be deleted in a certain order e.g. Delete Property Manager first, then you can delete tenants as long as they aren't a head tenant at a property
// Then you can delete a property regardless of whom is in it.

	@GetMapping("/deletePropManager")
		public String deletePropManager(@RequestParam int id) {
			if (repopm.findById(id).isPresent()) {
				repopm.delete(repopm.findById(id).get());
			}
			return "redirect:/list";
		}
	
	@GetMapping("/deleteTenant")
	public String deleteTenant(@RequestParam String id) {
		if (repot.findById(id).isPresent()) {
			repot.delete(repot.findById(id).get());
		}
		return "redirect:/list";
	}
	
	@GetMapping("/deleteProperty")
	public String deleteProperty(@RequestParam int id) {
		if (repop.findById(id).isPresent()) {
			repop.delete(repop.findById(id).get());
		}
		return "redirect:/list";
}
}
