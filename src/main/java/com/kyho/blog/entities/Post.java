package com.kyho.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
	
	//db의 테이블과 매치
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
	private Long postId;

	@Column(name = "title")
	private String title;

	@Column(name = "body")
	private String body;

	@Column(name = "date_created")
	private Date dateCreated;

	// many to one join
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;

	public Post() {

		}

	public Long getPostId() {
			return this.postId;
		}

	public void setPostId(Long postId) {
			this.postId = postId;
		}

	public String getTitle() {
			return this.title;
		}

	public void setTitle(String title) {
			this.title = title;
		}
		
	public String getBody() {
			return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getCreator() {
		return this.creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}
