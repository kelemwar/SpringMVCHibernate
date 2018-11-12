package org.SimpleBlog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filedb")
public class Article {

	@Id
	@Column(name="file_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String category;
	private String description;

	private byte[] file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}




	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", title='" + title + '\'' +
				", category='" + category + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
