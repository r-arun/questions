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
@Table(name = "answers")
@NoArgsConstructor
@Data
public class Answers {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "question_id")
	private int questionId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "text_id")
	private Texts text;

	@Column(name = "relevance")
	private int relevance;
	
	@Column(name = "created_timestamp")
	private Date createdTimeStamp;
}
