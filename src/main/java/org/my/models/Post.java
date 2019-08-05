package org.my.models;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Post {
	private Long id;
	private String title;
	private String content;
	private Date createdAt = new Date();
	
	private Set<Tag> tags = new TreeSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Transient
	public List<String> getTagNames() {
		List<String> tagNames= new ArrayList<>();
		for (Tag tag : tags) {
			tagNames.add(tag.getTagName());
		}
		return tagNames;
	}
	
}
