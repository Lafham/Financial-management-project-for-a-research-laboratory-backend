package ISI.Projet.GestionFinanciereLabo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ExpBesoins {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double montantApproximatif;
	private boolean valide;
	@Temporal(TemporalType.DATE)
	private Date dateDemande;
	@Temporal(TemporalType.DATE)
	private Date dateValidation;
	@ManyToOne
	private Membre membre;
	@ManyToOne
	private Responsable responsable;
	@ManyToOne
	private TypeBesoin typeBesoin;
	
	public void isValid() {
		
	}
}
