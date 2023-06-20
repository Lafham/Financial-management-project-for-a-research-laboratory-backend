package ISI.Projet.GestionFinanciereLabo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class TypeBesoin {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	@OneToMany(mappedBy = "typeBesoin")
	@JsonProperty(access = Access.WRITE_ONLY) 
	private Set<ExpBesoins> besoins = new HashSet<ExpBesoins>();

}
