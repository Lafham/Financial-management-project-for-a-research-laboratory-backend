package ISI.Projet.GestionFinanciereLabo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.Membre;
@Repository
public interface MembreRepository extends JpaRepository<Membre, Long>{

	Membre findByEmail(String email);
}
	