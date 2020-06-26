package com.route.routePlanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.route.routePlanner.form.InputForm;
import com.route.routePlanner.service.ProcessService;

@RestController
@RequestMapping("/")
public class ProcessController {

	@Autowired
	ProcessService service;

	@PostMapping("/findRoute")
	public void findRoute(@RequestBody InputForm inputForm) {
		try {
			service.processInput(inputForm);
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
