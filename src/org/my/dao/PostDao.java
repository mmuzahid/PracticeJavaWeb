package org.my.dao;

import java.util.List;

import org.my.models.Post;

public interface PostDao {
	public Post getPostByID(Long id);
	public  Long savePost(Post post);
	public List<Post> getAllPost();
	public void deletePostByID(Post post);
}
