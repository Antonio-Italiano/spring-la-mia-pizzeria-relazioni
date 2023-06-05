package org.java.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String descrizione;
	@Column(columnDefinition = "TEXT")
	private String fotoUrl;
	private double prezzo;

	@OneToMany(mappedBy = "pizza")
	private List<OffertaSpeciale> offertaSpeciali;
	
	@ManyToMany
	private List<Ingredienti> ingredienti;
	
	public Pizza() { }
	public Pizza(String nome, String descrizione, String fotoUrl, double prezzo) {
		setNome(nome);
		setDescrizione(descrizione);
		setFotoUrl(fotoUrl);
		setPrezzo(prezzo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public List<OffertaSpeciale> getOffertaSpeciali() {
		return offertaSpeciali;
	}
	
	public void setOffertaSpeciali(List<OffertaSpeciale> offertaSpeciali) {
		this.offertaSpeciali = offertaSpeciali;
	}
	
	public List<Ingredienti> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingredienti> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId() 
				+ "\nnome: " + getNome() 
				+ "\ndescrizione :" + getDescrizione() 
				+ "\nfotoUrl: " + getFotoUrl()
				+ "\nprezzo: " + getPrezzo() + "€\n";
	}
}
