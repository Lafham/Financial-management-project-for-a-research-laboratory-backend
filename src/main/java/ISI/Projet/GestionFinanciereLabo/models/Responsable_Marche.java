package ISI.Projet.GestionFinanciereLabo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
public class Responsable_Marche extends Responsable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
