package org.my.controllers;

import java.util.Date;

import org.my.models.Post;
import org.my.models.Tag;
import org.my.services.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		post.setTitle("Test Title");
		post.setContent("Test Content");
		post.setCreatedAt(new Date());
		
		Tag tag = new Tag();
		tag.setPost(post);
		tag.setTagName("JAVA");

		post.getTags().add(tag);
		
		tag = new Tag();
		tag.setPost(post);
		tag.setTagName(".NET");

		post.getTags().add(tag);
		
		rootService.savePost(post);
	    return "saved post id: " + post.getId();
	}
	
	@RequestMapping(value= "/editpost/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String editPost(@PathVariable Long id) {
		Post post =  rootService.getPost(id);
		post.setTitle("New Title");
		post.setContent("New Content");
		
		Tag tag = new Tag();
		tag.setPost(post);
		tag.setTagName("PYTHON");		
		
		post.getTags().clear();
		post.getTags().add(tag);

		rootService.savePost(post);
	    return "updated post id: " + post.getId();
	}
	
	@RequestMapping(value= "/deletepost/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String deletePost(@PathVariable Long id) {
		Post post =  rootService.getPost(id);
		rootService.deletePost(post);
	    return "deleted post id: " + post.getId();
	}
	
}
