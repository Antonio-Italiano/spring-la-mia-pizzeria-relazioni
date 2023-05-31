package org.java.demo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OffertaSpeciale {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titolo;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private Integer percentualeSconto;
	
	@ManyToOne
	private Pizza pizza;
	
	public OffertaSpeciale() {}
	
	public OffertaSpeciale(String titolo, LocalDate dataInizio, LocalDate dataFine, Integer percentualeSconto, Pizza pizza) {
		
		setTitolo(titolo);
		setDataInizio(dataInizio);
		setDataFine(dataFine);
		setPercentualeSconto(percentualeSconto);
		setPizza(pizza);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public Integer getPercentualeSconto() {
		return percentualeSconto;
	}

	public void setPercentualeSconto(Integer percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public double getPrezzoFinale() {
		
		double prezzoPizza = getPizza().getPrezzo();
		double sconto = prezzoPizza / 100 * getPercentualeSconto();
		
		return prezzoPizza - sconto;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "]" + getTitolo() 
		+ " , Inizio: " + getDataInizio() 
		+ " , fine: " + getDataFine() 
		+ " , sconto: " + getPercentualeSconto() + "%"
		+ " , prezzo: " + getPrezzoFinale() + "€";
	}
}
