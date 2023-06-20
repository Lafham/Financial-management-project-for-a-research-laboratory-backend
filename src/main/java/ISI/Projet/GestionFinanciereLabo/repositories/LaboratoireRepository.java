package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.Laboratoire;
@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long>{

}
