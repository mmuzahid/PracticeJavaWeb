package org.my.dao;

import java.util.List;

import org.my.models.Post;

public interface PostDao {
	public Post getPostByID(Long id);
	public  Long savePost(Post post);
	public boolean deletePostByID(Long id);
	public List<Post> getAllPost();
}
