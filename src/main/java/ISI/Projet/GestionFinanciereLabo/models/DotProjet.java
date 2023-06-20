package ISI.Projet.GestionFinanciereLabo.models;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class DotProjet {
	
	@EmbeddedId
	private DotProjetID dotProjetID;
	private double dotation;
	private Date dateDebut;
	private Date dateFin;
	private boolean responsableProjet;
	
}
