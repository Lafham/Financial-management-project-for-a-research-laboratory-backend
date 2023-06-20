package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.Projet;
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{

}
