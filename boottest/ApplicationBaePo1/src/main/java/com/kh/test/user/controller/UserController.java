package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/selectId")
	public String selectId(@RequestParam("selectId")String selectId, Model model) {
		
		User user = service.selectId(selectId);
		
		String path = "";
		if(user != null) {
			model.addAttribute("user",user);
			path = "/searchSuccess";
		}else {
			path = "/searchFail";
		}
		
		return path;
	}
	
}