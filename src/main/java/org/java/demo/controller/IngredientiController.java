package org.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Ingredienti;
import org.java.demo.pojo.Pizza;
import org.java.demo.service.IngredientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientiController {

	@Autowired
	private IngredientiService ingredientiService;
	
	@GetMapping("/ingredienti")
	public String index(Model model) {
		
		List<Ingredienti> ingredienti = ingredientiService.findAll();
		
		model.addAttribute("ingredienti", ingredienti);
		
		return "ingredienti-index";
	}
	
	@GetMapping("ingredienti/create")
	public String getIngredientiCreate(Model model){
		
		model.addAttribute("ingredienti", new Ingredienti());
		
		return "ingredienti-create";
	}
	
	@PostMapping("ingredienti/create")
	public String storeIngredienti( Model model, @ModelAttribute Ingredienti Ingredienti, BindingResult bindingResult) {
		
		ingredientiService.save(Ingredienti);
		
		return "redirect:/ingredienti";
	}
	
	@GetMapping("ingredienti/update/{id}")
	public String editIngredienti(Model model, @PathVariable int id) {
		
		Optional<Ingredienti> optIngredienti = ingredientiService.findById(id);
		Ingredienti ingredienti = optIngredienti.get();
		
		model.addAttribute("ingredienti", ingredienti);
		
		return "ingredienti-edit";
	}
	
	@PostMapping("ingredienti/update/{id}")
	public String updateIngredienti(Model model, @PathVariable int id, @ModelAttribute Ingredienti ingredienti, BindingResult bindingResult) {
						
		ingredientiService.save(ingredienti);
		
		return "redirect:/ingredienti";
	}
	
	@GetMapping("/ingredienti/delete/{id}")
	public String deleteIngredienti(
			@PathVariable int id
		) {
		
		Optional<Ingredienti> ingredientiOpt = ingredientiService.findById(id);
		Ingredienti ingredienti = ingredientiOpt.get();
		
		if(ingredienti.getPizze().size() != 0) {
			for(Pizza p : ingredienti.getPizze()) {
				p.getIngredienti().remove(ingredienti);
			}
		}
		
		ingredientiService.deleteIngredienti(ingredienti);
		
		return "redirect:/ingredienti";
	}
}
