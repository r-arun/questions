package com.home.project.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="topics")
@Data
@NoArgsConstructor
public class Topics {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="topic_name")
	private String topicName;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "topic_id")
	private List<Questions> questionsList;
}
