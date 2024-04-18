package com.sistemi.informativi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.document.Course;
import com.sistemi.informativi.document.Review;
import com.sistemi.informativi.repository.CourseRepository;

@RestController
@RequestMapping("/rest/api/courses")
public class CourseController {
	
	
	private CourseRepository courseRepository;
	
	public CourseController(CourseRepository courseRepository) {
		
		this.courseRepository = courseRepository;
	}


	@PostMapping
	public Course saveCourse(@RequestBody Course course) {
		
		return courseRepository.save(course);
		
	}
	
	@GetMapping
	public List<Course> findAllCourses(){
		
		
		return courseRepository.findAll();
		
		
	}
	
	@GetMapping("/{code}/reviews-by-course")
	public List<Review> findAllReviewsByCourse(@PathVariable("code") String code) throws Exception{
		
		return courseRepository.findById(code).orElseThrow(()->new Exception("not found")).getReviews();
		
	}
	
	

}
