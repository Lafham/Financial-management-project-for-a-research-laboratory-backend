package ISI.Projet.GestionFinanciereLabo.models;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Laboratoire {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String telephone;
	@Column(unique = true)
	private String email;
	
	
	@OneToMany(mappedBy="laboratoire", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonIgnore
	private Set<Membre> membres = new HashSet<Membre>();


    @ManyToOne()
    @JoinColumn(name = "etablissement_id")
    private Etablissement etablissement;
}
