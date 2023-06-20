package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.ExpBesoins;
import ISI.Projet.GestionFinanciereLabo.repositories.ExpBesoinsRepository;

@Service
public class ExpBesoinsService {

    private final ExpBesoinsRepository expBesoinsRepository;

    public ExpBesoinsService(ExpBesoinsRepository expBesoinsRepository) {
        this.expBesoinsRepository = expBesoinsRepository;
    }

    // Méthode pour créer un nouvel ExpBesoins
    public ExpBesoins createExpBesoins(ExpBesoins expBesoins) {
        return expBesoinsRepository.save(expBesoins);
    }

    // Méthode pour récupérer tous les ExpBesoins
    public List<ExpBesoins> getAllExpBesoins() {
        return expBesoinsRepository.findAll();
    }

    // Méthode pour récupérer un ExpBesoins par son ID
    public ExpBesoins getExpBesoinsById(Long id) {
        return expBesoinsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ExpBesoins introuvable avec l'ID : " + id));
    }

    // Méthode pour mettre à jour un ExpBesoins existant
    public ExpBesoins updateExpBesoins(Long id, ExpBesoins updatedExpBesoins) {
        ExpBesoins expBesoins = expBesoinsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ExpBesoins introuvable avec l'ID : " + id));

        expBesoins.setValide(updatedExpBesoins.isValide());
        expBesoins.setDateDemande(updatedExpBesoins.getDateDemande());
        expBesoins.setMembre(updatedExpBesoins.getMembre());
        expBesoins.setResponsable(updatedExpBesoins.getResponsable());
        expBesoins.setTypeBesoin(updatedExpBesoins.getTypeBesoin());

        return expBesoinsRepository.save(expBesoins);
    }

    // Méthode pour supprimer un ExpBesoins par son ID
    public void deleteExpBesoins(Long id) {
        expBesoinsRepository.deleteById(id);
    }
}

