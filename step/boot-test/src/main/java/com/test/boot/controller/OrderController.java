package com.test.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
	
	@PostMapping("/order")
	public String order(String name, String blackPen, String redPen, String bluePen, String white,
						Model model) {

		int total = 0;

		total = Integer.parseInt(blackPen) * 500
			+ Integer.parseInt(redPen) * 700
			+ Integer.parseInt(bluePen) * 700
			+ Integer.parseInt(white) * 1000;
		
		if(total == 0) {
			return "redirect:/error";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("blackPen", blackPen);
		model.addAttribute("redPen", redPen);
		model.addAttribute("bluePen", bluePen);
		model.addAttribute("white", white);
		model.addAttribute("total", total);
		
		return "resultPage";
	}
	
	@GetMapping("/error")
	public String error() {
		return "errorPage";
	}

	
}
