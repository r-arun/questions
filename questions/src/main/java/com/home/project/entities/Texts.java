package com.home.project.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "texts")
@NoArgsConstructor
@Data
public class Texts {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "version")
	private int version;
	
	@Column(name = "last_updated")
	private Date lastUpdated;
}
