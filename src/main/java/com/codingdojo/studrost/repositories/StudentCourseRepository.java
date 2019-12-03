package com.codingdojo.studrost.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studrost.models.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long>{

	
}
