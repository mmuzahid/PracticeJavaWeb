package org.my.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This Controller is available when there is not Servlet WebApplicationContext available;
 * i.e. when  root WebApplicationContext is one and only context
 * we can enable this in web.xml by removing all servlet
 * */
@Controller
public class RootController {
	@RequestMapping(value= "/rootaction", method = RequestMethod.GET)
	@ResponseBody
	public String rootaction() {
	    return "Root Response!";
	}
	
}
