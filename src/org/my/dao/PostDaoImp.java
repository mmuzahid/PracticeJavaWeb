package org.my.dao;

import java.util.List;

import org.my.models.Post;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PostDaoImp extends HibernateDaoSupport implements PostDao {
	@Override
	public Post getPostByID(Long id) {
		//TODO implementation
		return null;
	}

	@Override
	public Long savePost(Post post) {
		if (post.getId() == null) {
			post.setId((Long) getHibernateTemplate().save(post));
		} else {
			getHibernateTemplate().update(post);
		}
		return post.getId();
	}

	@Override
	public boolean deletePostByID(Long id) {
		//TODO implementation
		return false;
	}

	@Override
	public List<Post> getAllPost() {
		//TODO implementation
		return null;
	}

}
