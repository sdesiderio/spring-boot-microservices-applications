package com.sistemi.informativi.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection="course")
public class Course {
	
	@MongoId
	private String code;
	
	private String title;
	
	private List<Review> reviews;
	
	private List<Student> students;
	
	private List<Teacher> teachers;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	protected Course() {
		
	}

	public Course(String code, String title, List<Review> reviews, List<Student> students, List<Teacher> teachers) {
		
		this.code = code;
		this.title = title;
		this.reviews = reviews;
		this.students = students;
		this.teachers = teachers;
	}
	
	
	

}
