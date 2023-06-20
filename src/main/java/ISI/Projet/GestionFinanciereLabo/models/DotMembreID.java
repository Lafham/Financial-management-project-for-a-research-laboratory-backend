package ISI.Projet.GestionFinanciereLabo.models;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

 @Embeddable @AllArgsConstructor @NoArgsConstructor @Data @ToString
public class DotMembreID {

	private Long membre_id;
	private Long dotation_id;
}
