package com.dj.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dj.entity.Student;

@RestController
@RequestMapping("api")
public class StudentRestController {

	private List<Student> list;

	@PostConstruct
	public void loadData() {
		list = new ArrayList<Student>();
		list.add(new Student("Dhananjay", "Sengraphwar"));
		list.add(new Student("Pooja", "Sawant"));
	}

	@GetMapping("/students")
	public List<Student> getStudentList() {
		return list;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (list.size() < studentId || studentId < 0) {
			throw new StudentNotFoundException("Student id is not present :" + studentId);
		}
		return list.get(studentId);
	}
}
