package org.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.java.demo.interfaccia.OffertaSpecialeRepo;
import org.java.demo.pojo.OffertaSpeciale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaSpecialeService {

	@Autowired
	private OffertaSpecialeRepo offertaSpecialeRepo;
	
	public List<OffertaSpeciale> findAll(){	
		return offertaSpecialeRepo.findAll();
	}
	
	public Optional<OffertaSpeciale> findById(int id){	
		return offertaSpecialeRepo.findById(id);
	}
	
	public OffertaSpeciale save(OffertaSpeciale offertaSpeciale) {
		return offertaSpecialeRepo.save(offertaSpeciale);
	}
}
