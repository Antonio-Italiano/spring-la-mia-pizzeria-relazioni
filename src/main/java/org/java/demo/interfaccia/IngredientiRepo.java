package org.java.demo.interfaccia;

import org.java.demo.pojo.Ingredienti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientiRepo extends JpaRepository<Ingredienti, Integer>{

}
