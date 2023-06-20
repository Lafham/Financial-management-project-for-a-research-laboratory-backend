package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.DotProjet;
import ISI.Projet.GestionFinanciereLabo.models.DotProjetID;
@Repository
public interface DotProjetRepository extends JpaRepository<DotProjet, DotProjetID>{

}
