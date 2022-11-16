package com.prog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Student;
import com.prog.service.StudentService;


@Controller
public class EmpController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Student> Students=service.getAllStudent();
		m.addAttribute("Student", Students);
		
		return "index";
	}
	
	@GetMapping("/addstudent")
	public String addstudent()
	{
		return "addstudent";
	}
	
	@PostMapping("/register")
	public String studentRegister(@ModelAttribute Student s,HttpSession session)
	{
		System.out.println(s);
		
		service.addStudent(s);
		session.setAttribute("msg", "Student Added Sucessfully in TECH.I.S");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Student s=service.getStudentById(id);
		m.addAttribute("Student",s);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student s, HttpSession session)
	{
		service.addStudent(s);
		session.setAttribute("msg", "Student Data Update Sucessfully in TECH.I.S");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id, HttpSession session)
	{
		service.deleteStudent(id);
		session.setAttribute("msg", "Student Data Delete Sucessfully in TECH.I.S");
		return "redirect:/";
	}
}
