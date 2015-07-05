package com.home.project.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Data
public class Questions {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "parent_id", nullable=true)
	private Integer parentId;

	@Column(name = "topic_id")
	private int topicId;

	@Column(name = "created_timestamp")
	private Date createdTimestamp;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "relevance")
	private int relevance;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "text_id")
	private Texts text;
}