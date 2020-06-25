package com.derinsweb.springJpaWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.derinsweb.springJpaWebApp.repositories.AuthorRepository;


@Controller
public class AuthorController {

	private final AuthorRepository authorRepository;
	
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}


	@GetMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors",authorRepository.findAll());
		
		return "authors/list";
	}
}
