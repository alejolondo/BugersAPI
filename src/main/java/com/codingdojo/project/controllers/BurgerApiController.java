package com.codingdojo.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.project.models.Burger;
import com.codingdojo.project.service.BurgerService;

@RestController
@RequestMapping("/api")
public class BurgerApiController {

	@Autowired
	private BurgerService service;
	
	@GetMapping("/burgers")
	public List<Burger> encontrarTodos(){
		return service.findAll();
	}
	
	@GetMapping("/burgers/{id}")
	public Burger encontrar(@PathVariable("id") Long id) {
		
		return service.findById(id);
	}
	
	@PostMapping("/burgers")
	public Burger crearRegistro(@RequestParam("burgerName")String burgerName,
								@RequestParam("restaurantName")String restaurantName,
								@RequestParam("rating")int rating) {
		
		
		Burger burger = new Burger(burgerName, restaurantName, rating);
		
		return service.save(burger);
	}
	
	@PutMapping("/burgers/{id}")
	public Burger actualizarRegistro(@PathVariable("id")Long id,
			@RequestParam("burgerName")String burgerName,
			@RequestParam("burgerName")String restaurantName,
			@RequestParam("rating")int rating) {
		
		Burger newBurger = new Burger(id, burgerName, restaurantName, rating);
		return service.save(newBurger);
	}
	
	@DeleteMapping("/burger/{id}")
	public void delete(@PathVariable("id")Long id) {
		
		service.delete(id);
	}
}
