package com.codingdojo.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.models.Burger;

@Repository
public interface BurgerRepository  extends JpaRepository<Burger, Long>{

	
}
