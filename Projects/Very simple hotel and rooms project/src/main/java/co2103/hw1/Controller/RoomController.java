package co2103.hw1.Controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Hotel;
import co2103.hw1.domain.Room;

@Controller
public class RoomController {
	
	@InitBinder("room")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new RoomValidator());
	}
	
	@GetMapping("/rooms")
	public String room(@RequestParam int hotel, Model model) {
		
		for (Hotel r: Hw1Application.hotels) {
			if (r.getId() == hotel) {
			model.addAttribute("rooms", r.getRooms());
			model.addAttribute("hotel", r.getId());
	
			}
		}
		return ("rooms/list");
	}
	
	@RequestMapping("/newRoom")
	public String newRoom(@RequestParam(value="hotel") int hotel, Model model) {
		model.addAttribute("hotel", hotel);
		model.addAttribute("room", new Room());
		return ("rooms/form");
	}
	
	@PostMapping("/addRoom")
	public String addRoom(@Valid @ModelAttribute Room room,  BindingResult result, @RequestParam(value="hotel") int hotel, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("hotel", hotel);
			return "rooms/form";
		}
		
		Hotel a = null;
		
		for (Hotel rooms : Hw1Application.hotels) {
			if (rooms.getId() == hotel) {
				a = rooms;
				a.getRooms().add(room);
				break;
			}
		}
		return "redirect:/hotels";
	}
}
