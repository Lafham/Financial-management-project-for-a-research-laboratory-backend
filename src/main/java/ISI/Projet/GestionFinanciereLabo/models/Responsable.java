package ISI.Projet.GestionFinanciereLabo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Responsable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String email;
	private String telephone;
	private String password;
	private double montantEffectif;
	@Temporal(TemporalType.DATE)
	private Date dateEffet;
	
	@OneToMany(mappedBy = "responsable")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<ExpBesoins> besoins = new HashSet<ExpBesoins>();
	
}
