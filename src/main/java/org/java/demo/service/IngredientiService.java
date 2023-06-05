package org.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.java.demo.interfaccia.IngredientiRepo;
import org.java.demo.pojo.Ingredienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientiService {

	@Autowired
	private IngredientiRepo ingredientiRepo;
	
	public List<Ingredienti> findAll() {
		return ingredientiRepo.findAll();
	}
	
	public Optional<Ingredienti> findById(int id){	
		return ingredientiRepo.findById(id);
	}
	
	public Ingredienti save(Ingredienti ingredienti) {
		return ingredientiRepo.save(ingredienti);
	}

	public void deleteIngredienti(Ingredienti ingredienti) {
		
		ingredientiRepo.delete(ingredienti);
	}
}
