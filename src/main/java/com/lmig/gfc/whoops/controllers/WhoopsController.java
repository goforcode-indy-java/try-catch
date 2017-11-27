package com.lmig.gfc.whoops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WhoopsController {
	
	@PostMapping("/handle-error")
	public ModelAndView handleError(String message) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("whoops");
		
		// If message = "Marci is slightly confused about substring"
		// then message.substring(3, 17) => "ci is slightl"
		try {
			mv.addObject("mangledMessage", message.substring(3, 17).toUpperCase());
		} catch(IndexOutOfBoundsException ioobe) {
			mv.addObject("error", ioobe);
			mv.addObject("mangledMessage", "Hey, put in at least 17 letters.");
		} catch(Exception e) {
			mv.addObject("mangledMessage", "An unspecified error occured. Please contact Customer Support at 3am.");
			mv.addObject("error", e);
		}
		return mv;
	}

	@GetMapping("/")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("whoops");
		return mv;
	}
	
}





