package edu.nojo.vote.writePetition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/writePetition")
@Controller
public class WritePetitionController {

	@GetMapping("/")
	public String writePetition() {
		return null;
	}
}
