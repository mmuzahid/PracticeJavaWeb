package org.my.services;

import java.util.List;

import org.my.dao.PostDao;
import org.my.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	/*@Autowired // Setter Autowired Example, alternative of a `@Autowired	private PostDao postDao;`
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}*/
	public String getData() {
		return "PostService - " + this.toString();
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
