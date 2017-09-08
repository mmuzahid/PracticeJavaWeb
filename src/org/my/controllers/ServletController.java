package org.my.controllers;

import org.my.services.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServletController {
	@Autowired
	RootService rootService;
	
	@RequestMapping(value= "/servletaction", method = RequestMethod.GET)
	@ResponseBody
	public String servletaction() {
	    return "ServletController Response! service data: " + rootService.getData();
	}
	
}
