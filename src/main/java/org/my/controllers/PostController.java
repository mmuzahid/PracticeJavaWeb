package org.my.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.my.models.Post;
import org.my.models.Tag;
import org.my.services.RootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	RootService rootService;

	@RequestMapping(value = "/servletaction", method = RequestMethod.GET)
	@ResponseBody
	public String servletaction() {
		return "PostController: rootServiceData - " + rootService.getData();
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	@ResponseBody
	public RedirectView defaultAction() {
		return new RedirectView("list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listPost() {
		List<Post> allPosts = rootService.getAllPost();
		ModelAndView listVIew = getPostListView();
		listVIew.getModel().put("posts", allPosts);

		return listVIew;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView newPost() {
		return getPostFormView();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView editPost(@RequestParam Long id) {
		Post post = rootService.getPost(id);
		ModelAndView formView = getPostFormView();
		formView.getModel().put("post", post);
		return formView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public RedirectView savePost(
			@ModelAttribute("post") Post post,
			@RequestParam(value = "tagStrings[]", required = false) List<String> tags) {
		setTags(post, tags);
		rootService.savePost(post);
		logger.info(String.format("post saved. id: %s", post.getId()));
		return new RedirectView("list");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public RedirectView deletePost(@RequestParam Long id) {
		Post post = rootService.getPost(id);
		rootService.deletePost(post);
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
		Set<Tag> tags = new HashSet<Tag>();
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
