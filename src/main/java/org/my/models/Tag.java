package org.my.models;

public class Tag implements Comparable<Tag> {
	private Integer recordId;
	private Post post;
	private String tagName;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@Override
	public int compareTo(Tag o) {
		return this.getTagName().compareTo(o.getTagName());
	}

}
