package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.ExpBesoins;
@Repository
public interface ExpBesoinsRepository extends JpaRepository<ExpBesoins, Long>{

}
