package ISI.Projet.GestionFinanciereLabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import ISI.Projet.GestionFinanciereLabo.models.Admin;

@RestController
public interface AdminRepository extends JpaRepository<Admin, Long> {


public Admin findByEmail(String email);
}
