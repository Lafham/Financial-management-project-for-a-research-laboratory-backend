package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.Membre;
import ISI.Projet.GestionFinanciereLabo.models.Projet;
import ISI.Projet.GestionFinanciereLabo.repositories.ProjetRepository;

@Service
public class ProjetService {
    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    public Projet findById(Long id) {
        return projetRepository.findById(id).orElse(null);
    }

    public List<Projet> findAll() {
        return projetRepository.findAll();
    }

    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }
    
    public Projet updateProjet(Long id, Projet projet) {
    	projet.setId(id);
    	return projetRepository.save(projet);
    }

    public void deleteById(Long id) {
        projetRepository.deleteById(id);
    }

    // Ajoute un membre au projet
    public void addMembre(Projet projet, Membre membre) {
        projet.getMembres().add(membre);
        membre.getProjets().add(projet);
        projetRepository.save(projet);
    }

    // Supprime un membre du projet
    public void removeMembre(Projet projet, Membre membre) {
        projet.getMembres().remove(membre);
        membre.getProjets().remove(projet);
        projetRepository.save(projet);
    }
}
