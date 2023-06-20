package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long>{

	Responsable findByEmail(String email);

}
