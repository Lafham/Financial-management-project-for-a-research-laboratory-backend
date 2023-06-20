package ISI.Projet.GestionFinanciereLabo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Projet {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private double budget;
	@ManyToMany(mappedBy = "projets")
	@JsonIgnore
	private Set<Membre> membres = new HashSet<Membre>();

}
