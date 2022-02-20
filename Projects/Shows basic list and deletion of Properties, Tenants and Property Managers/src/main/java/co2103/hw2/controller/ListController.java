package co2103.hw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co2103.hw2.repo.PropertyManagerRepository;
import co2103.hw2.repo.PropertyRepository;
import co2103.hw2.repo.TenantRepository;


@Controller
public class ListController {
	
	@Autowired
	private PropertyRepository repop;
	
	@Autowired
	private TenantRepository repot;
	
	@Autowired
	private PropertyManagerRepository repopm;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("propertys", repop.findAll());
		model.addAttribute("tenants", repot.findAll());
		model.addAttribute("propertymanagers", repopm.findAll());
		return "list";

}
}
