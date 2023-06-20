package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.DotMembre;
import ISI.Projet.GestionFinanciereLabo.models.DotMembreID;
@Repository
public interface DotMembreRepository extends JpaRepository<DotMembre, DotMembreID>{

}
