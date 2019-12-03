package com.codingdojo.studrost.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studrost.models.Contact;
import com.codingdojo.studrost.models.Course;
import com.codingdojo.studrost.models.Dorm;
import com.codingdojo.studrost.models.Student;
import com.codingdojo.studrost.models.StudentCourse;
import com.codingdojo.studrost.repositories.ContactRepository;
import com.codingdojo.studrost.repositories.CourseRepository;
import com.codingdojo.studrost.repositories.DormRepository;
import com.codingdojo.studrost.repositories.StudentCourseRepository;
import com.codingdojo.studrost.repositories.StudentRepository;


@Service

public class ApiService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private DormRepository dormRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;
	
	
	
//  ----------------------------------------------------------------
//  find 
//  ----------------------------------------------------------------
	
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	

	public List<Course> allCourses() {
		return courseRepository.findAll();
	}

	
	public Dorm findDorm(Long id) {
		Optional<Dorm>optionalDorm = dormRepository.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}else
			return null;
	}
	
	public Dorm findDormById(Long dorm_id) {
		Optional<Dorm> optionalDorm = dormRepository.findById(dorm_id);
		if (optionalDorm.isPresent()) {
			return optionalDorm.get();
		} else {
		}
			return null;}
	
	public Student findStudentById(Long student_id) {
		Optional<Student> optionalStudent = studentRepository.findById(student_id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
		return null;
		}
	}


	public Course findCourse(Long course_id) {
		Optional<Course> optionalCourse = courseRepository.findById(course_id);
		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
		return null;
		}
		

	}
	

//  ----------------------------------------------------------------
//  create and delete
//  ----------------------------------------------------------------
	
	public Student createStudent(@Valid Student student) {
		return studentRepository.save(student);
		
	}


	public Contact createContact(@Valid Contact contact) {
		return contactRepository.save(contact);

	}


	public Dorm createDorm(@Valid Dorm dorm) {
		return dormRepository.save(dorm);
		
	}


	public Course createCourse(@Valid Course course) {
		return courseRepository.save(course);	
	}


	public StudentCourse createRelationship(@Valid StudentCourse studentCourse) {
		return studentCourseRepository.save(studentCourse);

	}


	public void removeCourse(Student thisStudent, Course thisCourse) {
		
		List<Course> studentCourses = thisStudent.getCourses();
		studentCourses.remove(thisCourse);
		
		createStudent(thisStudent);
		
	}


	
}
