package com.springboot.repositoryCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.repositoryCrud.entity.Address;
import com.springboot.repositoryCrud.entity.Search;
import com.springboot.repositoryCrud.entity.Student;
import com.springboot.repositoryCrud.repository.StudentRepository;
import com.springboot.repositoryCrud.search.StudentSearch;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	@Qualifier("studentSearch")
	private StudentSearch studentSearch;

	@GetMapping(value = "/home")
	public String display(Model model) {
		model.addAttribute("studentlist", studentRepository.findAll());
		model.addAttribute("studentSearch", new Search());
		return "student/studentview";
	}

	@GetMapping(value = "/studentform")
	public String displayInsertStudentform(Model model) {
		model.addAttribute("student", new Student());
		return "student/insertstudent";
	}

	@PostMapping(value = "/insert")
	public String insertStudent(Model model, @ModelAttribute("student") Student student) {
		studentRepository.save(student);
		return "redirect:/home";
	}

	@GetMapping(value = "/edit/{studentId}")
	public String editForm(Model model, @PathVariable("studentId") int studentId) {
		model.addAttribute("studentEdit", studentRepository.getOne(studentId));
		return "student/editstudent";
	}

	@PostMapping("/update")
	public String updateUser(Model model, @ModelAttribute("studentEdit") Student studentEdit) {
		if (studentEdit != null) {
			studentRepository.save(studentEdit);
			return "redirect:/home";
		} else {
			return "student/editstudent";
		}
	}

	@GetMapping("/delete/{studentId}")
	public String deleteUser(Model model, @PathVariable("studentId") int studentdeleteId) {
		studentRepository.delete(studentdeleteId);
		return "redirect:/home";
	}

//	@GetMapping("/search")
//	public String searchUser(Model model, @ModelAttribute("studentsearch") Search searchName) {
//		model.addAttribute("studentsearch", new Search());
//		if (searchName.getSearchText().isEmpty()) {
//			model.addAttribute("studentinfo", studentRepository.findAll());
//			return "student/studentview";
//		} else {
//			model.addAttribute("studentSearch", studentSearch.search(searchName.getSearchText()));
//			return "student/studentsearch";
//		}
//	}

//	@GetMapping("/search")
//	public String findStudentByCountry(Model model, @ModelAttribute("studentsearch") int id) {
////		model.addAttribute("studentsearch", new Search());
////		model.addAttribute("studentinfo", studentRepository.findAll());
////		model.addAttribute("studentSearch",studentRepository.findStudentsByCountry(1));
//		System.out.println(studentRepository.findStudentsByCountry(1).toString());
//		return "student/studentsearch";
//
//	}
	@GetMapping(value = "/")
	public String openSearchForm(Model model) {
		model.addAttribute("studentSearchQuery",new Search());
		return "student/query";
	}
	

	@GetMapping("/searchquery")
	public String viewByQuery(Model model, @ModelAttribute("studentSearchQuery")int id){
		System.out.println("enter here");
		System.out.println(studentRepository.findStudentsByCountry(1).toString());
		return "redirect:/home";
	}
	
}
