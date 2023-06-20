package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.DotationUcaRech;
@Repository
public interface DotationUcaRechRepository extends JpaRepository<DotationUcaRech, Long>{

}
