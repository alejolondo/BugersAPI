package com.codingdojo.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.project.models.Burger;
import com.codingdojo.project.repository.BurgerRepository;

@Service
public class BurgerService {

	
	@Autowired
	private BurgerRepository repository;
	
	
	public List<Burger> findAll(){
		return repository.findAll();
	}
	
	public Burger findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public Burger save(Burger burger) {
		return repository.save(burger);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
