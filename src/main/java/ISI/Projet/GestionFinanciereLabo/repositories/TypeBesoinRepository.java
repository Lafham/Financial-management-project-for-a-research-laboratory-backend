package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISI.Projet.GestionFinanciereLabo.models.TypeBesoin;

@Repository
public interface TypeBesoinRepository extends JpaRepository<TypeBesoin, Long>{

}
