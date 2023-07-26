package com.codingdojo.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.project.models.Burger;
import com.codingdojo.project.service.BurgerService;

@Controller
public class BurgerController {
	
	@Autowired
	private BurgerService service;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		
		List<Burger> burgers = service.findAll();
		model.addAttribute("burgers", burgers);
		
		return "index.jsp";
	}
	
	@GetMapping("/burgers/new")
	public String formulario(@ModelAttribute("burger") Burger burger) {
		
		return "formulario.jsp";
		
	}
	
	@PostMapping("/burgers/create")
	public String crear(@Valid @ModelAttribute("burger")Burger burger, 
						BindingResult result) {
		if(result.hasErrors()) {
			return "formulario.jsp";
		}else {
			service.save(burger);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String editar(@PathVariable("id")Long id, 
						Model model,
						@ModelAttribute("burger") Burger burger) {
		Burger burgerEdit = service.findById(id);
		model.addAttribute("burger", burgerEdit);
		
		return "edit.jsp";
	}
	
	@PutMapping("/burgers/edit/{id}")
	public String guardarEdicion(@Valid @ModelAttribute("burger")Burger burger,
								BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			service.save(burger);
			return "redirect:/";
		}
		
		
	}
	
	@DeleteMapping("burgers/delete/{id}")
	public String borrar(@PathVariable("id")Long id) {
		
		service.delete(id);
		
		return "redirect:/";
	}


}
