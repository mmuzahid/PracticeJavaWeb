package org.my.controllers;

import java.util.Date;

import org.my.models.Post;
import org.my.models.Tag;
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
	
	@RequestMapping(value= "/createpost", method = RequestMethod.GET)
	@ResponseBody
	public String createPost() {
		Post post = new Post();
		// for update uncomment this: post.setId(32l);
		post.setTitle("Test Title2");
		post.setContent("Test Content2");
		post.setCreatedAt(new Date());
		
		Tag tag = new Tag();
		tag.setPost(post);
		tag.setTagName("JAVA100");
		
		Tag ctag = new Tag();
		ctag.setPost(post);
		ctag.setTagName("C100");
		
		Tag ptag = new Tag();
		ptag.setPost(post);
		ptag.setTagName("PYTHON100");
		
		
		post.getTags().add(tag);
		post.getTags().add(ctag);
		post.getTags().add(ptag);
				
		rootService.savePost(post);
	    return "saved post id: " + post.getId();
	}
	
}
