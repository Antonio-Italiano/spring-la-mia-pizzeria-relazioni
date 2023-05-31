package org.java.demo.controller;

import java.util.Optional;

import org.java.demo.pojo.OffertaSpeciale;
import org.java.demo.pojo.Pizza;
import org.java.demo.service.OffertaSpecialeService;
import org.java.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OffertaSpecialeController {

	@Autowired
	private OffertaSpecialeService offertaSpecialeService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("pizze/{pizzaId}/offerta-speciale/create")
	public String getOffertaSpecialeCreate(@PathVariable int pizzaId, Model model){
		
		model.addAttribute("offertaSpeciale", new OffertaSpeciale());
		model.addAttribute("pizzaId", pizzaId);
		
		return "offerta-create";
		
	}
	
	@PostMapping("pizze/{pizzaId}/offerta-speciale/create")
	public String storeOffertaSpeciale(@PathVariable int pizzaId, Model model, @ModelAttribute OffertaSpeciale OffertaSpeciale, BindingResult bindingResult) {
		
		Optional<Pizza> optPizza = pizzaService.findById(pizzaId);
		Pizza pizza = optPizza.get();
		
		OffertaSpeciale.setPizza(pizza);
		
		offertaSpecialeService.save(OffertaSpeciale);
		
		return "redirect:/pizze/" + OffertaSpeciale.getPizza().getId();
	}
	
	@GetMapping("pizze/{pizzaId}/offerta-speciale/edit/{id}")
	public String editOffertaSpeciale(Model model, @PathVariable int pizzaId, @PathVariable int id) {
		
		Optional<OffertaSpeciale> optOffertaSpeciale = offertaSpecialeService.findById(id);
		OffertaSpeciale offertaSpeciale = optOffertaSpeciale.get();
		
		model.addAttribute("pizzaId", pizzaId);
		model.addAttribute("offertaSpeciale", offertaSpeciale);
		
		return "offerta-edit";
		
	}
	
	@PostMapping("pizze/{pizzaId}/offerta-speciale/update/{id}")
	public String updatePizza(Model model, @PathVariable int pizzaId, @PathVariable int id, @ModelAttribute OffertaSpeciale offertaSpeciale, BindingResult bindingResult) {
		
		Optional<Pizza> optPizza = pizzaService.findById(pizzaId);
		Pizza pizza = optPizza.get();
		
		offertaSpeciale.setPizza(pizza);
		
		offertaSpecialeService.save(offertaSpeciale);
		
		return "redirect:/pizze/" + pizzaId;

	}
}
