package org.my.services;

import java.util.List;

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
	public Post getPost(Long id) {
		return postDao.getPostByID(id);
	}
	public void deletePost(Post post) {
		postDao.deletePostByID(post);
	}
	
	public List<Post> getAllPost() {
		return postDao.getAllPost();
	}
	
}
