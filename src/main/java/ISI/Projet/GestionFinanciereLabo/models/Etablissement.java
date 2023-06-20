package ISI.Projet.GestionFinanciereLabo.models;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Etablissement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String telephone;
	private String adresse;
	@Column(unique = true)
	private String email;
    @OneToMany(mappedBy = "etablissement", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Laboratoire> laboratoires = new HashSet<>();
	
}
