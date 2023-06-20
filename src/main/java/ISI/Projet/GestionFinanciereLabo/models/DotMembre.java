package ISI.Projet.GestionFinanciereLabo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class DotMembre {
	@EmbeddedId
	private DotMembreID dotmembreID;
	private double dotation_Membre ; 
}
