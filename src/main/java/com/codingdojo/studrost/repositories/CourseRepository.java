package com.codingdojo.studrost.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studrost.models.Course;
import com.codingdojo.studrost.models.Student;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findAll();
}
