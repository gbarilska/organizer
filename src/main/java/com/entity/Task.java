package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Task implements Serializable {
	@Id
	private Long id;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String description;

	public Task() {
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", status=" + status + ", description=" + description + "]";
	}

	public Task(Long id, String status, String description) {
		this.id = id;
		this.status = status;
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
