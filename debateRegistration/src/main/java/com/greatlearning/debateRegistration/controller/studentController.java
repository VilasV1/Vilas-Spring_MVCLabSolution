package com.greatlearning.debateRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.debateRegistration.service.studentService;
import com.greatlearning.debateRegistration.entity.student;

@Controller
@RequestMapping("/student")
public class studentController {
	@Autowired
	private studentService studentService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("request Recieved");

		List<student> theStudents = studentService.findAll();

		theModel.addAttribute("Students", theStudents);

		return "list-student";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		student theStudent = new student();

		theModel.addAttribute("Student", theStudent);
		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		student theStudent = studentService.findById(theId);

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		System.out.println(id);
		student theStudent;
		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else {
			theStudent = new student(id, name, department, country);

			studentService.save(theStudent);

		}
		return "redirect:/student/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		studentService.deleteById(theId);

		return "redirect:/student/list";

	}

}
