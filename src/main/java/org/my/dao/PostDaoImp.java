package org.my.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.my.models.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class PostDaoImp extends HibernateDaoSupport implements PostDao {
	
	public PostDaoImp(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}
	
	@Override
	public Post getPostByID(Long id) {
		return getHibernateTemplate().get(Post.class, id);
	}

	@Override
	public Long savePost(Post post) {
		if (post.getId() == null) {
			post.setId((Long) getHibernateTemplate().save(post));
		} else {
			getHibernateTemplate().update(post);
			// alternate option is merge(): Copy the state of the given object onto the persistent object
			// with the same identifier.
			// getHibernateTemplate().merge(post);
		}
		return post.getId();
	}

	@Override
	public void deletePostByID(Post post) {
		getHibernateTemplate().delete(post);
	}

	@Override
	public List<Post> getAllPost() {
		return (List<Post>) getHibernateTemplate().find("from Post");
	}
}
