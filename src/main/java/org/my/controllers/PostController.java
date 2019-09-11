package org.my.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.my.models.Post;
import org.my.models.Tag;
import org.my.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

	private static Logger logger = LoggerFactory.getLogger(PostController.class);
	private static final String POST_FORM_JSP = "/WEB-INF/jsp/post_form.jsp";
	private static final String POST_LIST_JSP = "/WEB-INF/jsp/post_list.jsp";
	@Autowired
	PostService postService;

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value = "*")
	@ResponseBody
	public RedirectView defaultAction() {
		return new RedirectView("list");
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value = "/list")
	@ResponseBody
	public ModelAndView listPost() {
		List<Post> allPosts = postService.getAllPost();
		ModelAndView listVIew = getPostListView();
		listVIew.getModel().put("posts", allPosts);

		return listVIew;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/new")
	@ResponseBody
	public ModelAndView newPost() {
		return getPostFormView();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/edit")
	@ResponseBody
	public ModelAndView editPost(@RequestParam Long id) {
		Post post = postService.getPost(id);
		ModelAndView formView = getPostFormView();
		formView.getModel().put("post", post);
		return formView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/save")
	@ResponseBody
	public RedirectView savePost(
			@ModelAttribute("post") Post post,
			@RequestParam(value = "tagStrings[]", required = false) List<String> tags) {
		setTags(post, tags);
		postService.savePost(post);
		logger.info(String.format("post saved. id: %s", post.getId()));
		return new RedirectView("list");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/delete")
	@ResponseBody
	public RedirectView deletePost(@RequestParam Long id) {
		Post post = postService.getPost(id);
		postService.deletePost(post);
		logger.info(String.format("post deleted. id: %s", post.getId()));
		return new RedirectView("list");
	}

	private ModelAndView getPostListView() {
		ModelAndView model = new ModelAndView();
		model.setViewName(POST_LIST_JSP);
		return model;
	}

	private ModelAndView getPostFormView() {
		ModelAndView model = new ModelAndView();
		model.setViewName(POST_FORM_JSP);
		return model;
	}

	public void setTags(Post post, List<String> tagNames) {
		Set<Tag> tags = new HashSet<>();
		if (null != tagNames) {
			for (String tagName : tagNames) {
				Tag tag = new Tag();
				tag.setPost(post);
				tag.setTagName(tagName);
				tags.add(tag);
			}
		}
		
		post.setTags(tags);
	}
	
}
