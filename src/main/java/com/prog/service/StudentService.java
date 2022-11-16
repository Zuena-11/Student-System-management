package com.prog.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Student;
import com.prog.repository.Studentrepo;


@Service
public class StudentService {

	@Autowired
	private Studentrepo repo;
	
	public void addStudent(Student s)
	{
		repo.save(s);
	}
	
	public List<Student> getAllStudent()
	{
		 return repo.findAll();
	}
	
	public Student getStudentById(int id)
	{
		Optional<Student> s=repo.findById(id);
		if(s.isPresent()) {
			return s.get();
		}
		return null;
	}
	
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}
}
