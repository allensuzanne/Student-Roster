package com.codingdojo.studrost.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studrost.models.Contact;
import com.codingdojo.studrost.models.Course;
import com.codingdojo.studrost.models.Dorm;
import com.codingdojo.studrost.models.Student;
import com.codingdojo.studrost.models.StudentCourse;
import com.codingdojo.studrost.services.ApiService;

@Controller

public class RosterController {
	
	@Autowired
	private ApiService apiService;
	
	
//  ----------------------------------------------------------------
//  All Students - Get Route
//  ----------------------------------------------------------------
	
@GetMapping("/students")
public String allStudents(Model model) {
	List<Student> students = apiService.allStudents();
	model.addAttribute("students", students);
	return "students.jsp";
}

//----------------------------------------------------------------
//New Student - Get Route
//----------------------------------------------------------------

@GetMapping("/students/new")
public String newStudent(@ModelAttribute("studentObj") Student student) {
	return "studentsNew.jsp";
}


//----------------------------------------------------------------
//Create New Student - Post Route
//----------------------------------------------------------------

@PostMapping(value="/students/create")
public String create(@Valid @ModelAttribute("studentObj") Student student, BindingResult result) {
	if (result.hasErrors()) {
		return "studentsNew.jsp";  //returns if there are errors
	}else {
		apiService.createStudent(student);
		return "redirect:/students";
	}
}


//----------------------------------------------------------------
//New Contact - Get Route
//----------------------------------------------------------------

@GetMapping("/contact/new")
public String newContact(@ModelAttribute("contactObj") Contact contact, Model model) {
	List<Student> students = apiService.allStudents(); //hand in students, to use in dropdown
	model.addAttribute("students", students);
	return "contactNew.jsp";
}


//----------------------------------------------------------------
//Create New Contact - Get Route Using URL to Hand In Information
//----------------------------------------------------------------

@GetMapping("/contact/create")
public String createContact(@Valid @ModelAttribute("contactObj") Contact contact, BindingResult result) {
    if (result.hasErrors()) {
        return "contactNew.jsp";
    } else {
        apiService.createContact(contact);
        return "redirect:/students";
    }
}


//----------------------------------------------------------------
//New Dorm - Get Route
//----------------------------------------------------------------

@GetMapping("/dorms/new")
public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
	return "dormNew.jsp";
}


//----------------------------------------------------------------
//Create New Dorm - Post Route
//----------------------------------------------------------------

@PostMapping(value="/dorms/create")
public String create(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
	if (result.hasErrors()) {
		return "dormNew.jsp";  //returns if there are errors
	}else {
		apiService.createDorm(dorm);
		return "redirect:/dorms/"+dorm.getId();
	}
}


//----------------------------------------------------------------
//Show Dorm - Get Route
//----------------------------------------------------------------

@GetMapping("/dorms/{id}")
public String showDorm(@PathVariable("id")Long id, Model model) {
Dorm dormCreated = apiService.findDorm(id);
List<Student> students = apiService.allStudents(); //hand in students, to use in dropdown
model.addAttribute("students", students);
model.addAttribute("dorm", dormCreated);
return "dormId.jsp";
}


//----------------------------------------------------------------
//Add Student to Dorm - Post Route
//----------------------------------------------------------------

@PostMapping(value="/dorms/add")
public String addStudent(@RequestParam("dorm_id") Long dorm_id, @RequestParam("student_id")Long student_id) {
//	System.out.println(dorm_id);
//	System.out.println(student_id);
	Dorm thisDorm = apiService.findDormById(dorm_id);
	Student thisStudent = apiService.findStudentById(student_id);
	thisStudent.setDorm(thisDorm);
	apiService.createStudent(thisStudent);
	return "redirect:/dorms/"+dorm_id;
}


//----------------------------------------------------------------
//Remove Student from Dorm - Post Route
//----------------------------------------------------------------
@RequestMapping(value="/dorms/{student_id}/remove/{dorm_id}")
public String destroy(@PathVariable("student_id")Long student_id, @PathVariable("dorm_id")Long dorm_id) {
	Student thisStudent = apiService.findStudentById(student_id);
	thisStudent.setDorm(null);
	apiService.createStudent(thisStudent);
	return "redirect:/dorms/"+dorm_id;
}


//----------------------------------------------------------------
//New Courses - Get Route
//----------------------------------------------------------------

@GetMapping("/courses/new")
public String newCourse(@ModelAttribute("courseObj") Course course) {
	return "courseNew.jsp";
}

//----------------------------------------------------------------
//Create New Course - Post Route
//----------------------------------------------------------------

@PostMapping(value="/courses/create")
public String createCourse(@Valid @ModelAttribute("courseObj") Course course, BindingResult result) {
	if (result.hasErrors()) {
		return "courseNew.jsp";  //returns if there are errors
	}else {
		apiService.createCourse(course);
		return "redirect:/courses/"+course.getId();
	}
}



//----------------------------------------------------------------
//Show Course - Get Route
//----------------------------------------------------------------

@GetMapping("/courses/{id}")
public String showCourse(@PathVariable("id")Long id, Model model) {
Course courseCreated = apiService.findCourse(id);
List<Student> students = apiService.allStudents(); //hand in students, to use in dropdown
model.addAttribute("students", students);
model.addAttribute("course", courseCreated);
return "courseId.jsp";
}



//----------------------------------------------------------------
//Show Student - Get Route
//----------------------------------------------------------------

@GetMapping("/student/{id}")
public String showStudent(@PathVariable("id")Long id, Model model) {
	
Student studentCreated = apiService.findStudentById(id);
model.addAttribute("student", studentCreated);

List<Course> courses = apiService.allCourses(); 
model.addAttribute("courses", courses);

model.addAttribute(new StudentCourse());

return "studentId.jsp";
}


//----------------------------------------------------------------
//Add Student to Class - Post Route
//----------------------------------------------------------------
@PostMapping("/student/add/{id}")
public String newStudentClass(@PathVariable("id")Long student_id,  @RequestParam("course_id")Long course_id) {
	Student student = apiService.findStudentById(student_id);
	Course course = apiService.findCourse(course_id);
	StudentCourse studentCourse = new StudentCourse (student, course);
	apiService.createRelationship(studentCourse);
	return "redirect:/student/"+student_id;
}



//----------------------------------------------------------------
//Remove Student from Class - Post Route
//----------------------------------------------------------------
@RequestMapping(value="/courses/{student_id}/remove/{course_id}")
public String removeCourse(@PathVariable("student_id")Long student_id, @PathVariable("course_id")Long course_id) {
	Student thisStudent = apiService.findStudentById(student_id);
	Course thisCourse = apiService.findCourse(course_id);
	apiService.removeCourse(thisStudent, thisCourse);
	return "redirect:/student/"+student_id;
}

}














