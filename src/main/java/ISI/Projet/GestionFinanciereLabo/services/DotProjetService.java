package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.DotProjet;
import ISI.Projet.GestionFinanciereLabo.models.DotProjetID;
import ISI.Projet.GestionFinanciereLabo.repositories.DotProjetRepository;

@Service
public class DotProjetService {
    private final DotProjetRepository dotProjetRepository;

    @Autowired
    public DotProjetService(DotProjetRepository dotProjetRepository) {
        this.dotProjetRepository = dotProjetRepository;
    }
    
    public List<DotProjet> findAll(){
    	return dotProjetRepository.findAll();
    }

    public DotProjet findById(DotProjetID dotProjetID) {
        return dotProjetRepository.findById(dotProjetID).orElse(null);
    }

    public DotProjet addDotProjet(DotProjet dotProjet) {
        return dotProjetRepository.save(dotProjet);
    }
    public DotProjet updateDotProjet(DotProjetID id, DotProjet dotProjet) {
    	dotProjet.setDotProjetID(id);
    	return dotProjetRepository.save(dotProjet);
    }

    public void deleteById(DotProjetID dotProjetID) {
        dotProjetRepository.deleteById(dotProjetID);
    }
}
