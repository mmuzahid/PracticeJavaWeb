package org.my.controllers;

import org.my.services.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnotherServletController {
	@Autowired
	RootService rootService;
	
	@GetMapping(value= "/servletaction")
	@ResponseBody
	public String servletaction() {
	    return "AnotherServletController Response! service data: " + rootService.getData();
	}
	
}
