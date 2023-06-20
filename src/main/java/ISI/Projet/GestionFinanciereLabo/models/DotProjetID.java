package ISI.Projet.GestionFinanciereLabo.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable @Data @AllArgsConstructor @NoArgsConstructor
public class DotProjetID {
	private Long membre_id;
	private Long projet_id;

}
