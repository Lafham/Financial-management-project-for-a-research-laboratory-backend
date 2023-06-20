package ISI.Projet.GestionFinanciereLabo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class DotationUcaRech {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String annee;
	private double dotationBase ;
	@ManyToMany(mappedBy = "dotations" , cascade = CascadeType.ALL)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<Membre> membres = new HashSet<Membre>();
	
}
