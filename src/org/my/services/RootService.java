package org.my.services;

import org.my.dao.PostDao;
import org.my.models.Post;
import org.springframework.stereotype.Service;

@Service
public class RootService {
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	public String getData() {
		return "RootService";
	}
	
	public Post savePost(Post post) {
		Long savedId = postDao.savePost(post);
		post.setId(savedId);
		return post;
	}
	
}
