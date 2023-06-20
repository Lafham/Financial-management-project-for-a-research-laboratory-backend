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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @AllArgsConstructor @NoArgsConstructor 

@EqualsAndHashCode(exclude = "laboratoire")
@ToString(exclude = "laboratoire")
public class Membre{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String email;
	private String telephone;
	private String password;	
	
	private boolean isDirector;
	
	
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "laboratoire_id")
    private Laboratoire laboratoire;
    
    
	@OneToMany(mappedBy = "membre", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonIgnore
	private Set<ExpBesoins> besoins = new HashSet<ExpBesoins>();
	
	
	@ManyToMany
	@JoinTable(name = "DotProjet", joinColumns = @JoinColumn(name="membre_id"), inverseJoinColumns = @JoinColumn(name = "projet_id"))
	private Set<Projet> projets ;
	
	
	@ManyToMany
	@JoinTable(name = "DotMembre", joinColumns = @JoinColumn(name="membre_id"), inverseJoinColumns = @JoinColumn(name="dotation_id"))
	private Set<DotationUcaRech> dotations;
	
}
