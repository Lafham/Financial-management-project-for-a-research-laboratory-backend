package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.DotMembre;
import ISI.Projet.GestionFinanciereLabo.models.DotMembreID;
import ISI.Projet.GestionFinanciereLabo.repositories.DotMembreRepository;

@Service
public class DotMembreService {
	 private final DotMembreRepository dotMembreRepository;

	    @Autowired
	    public DotMembreService(DotMembreRepository dotMembreRepository) {
	        this.dotMembreRepository = dotMembreRepository;
	    }
	    
	    public List<DotMembre> findAll(){
	    	return dotMembreRepository.findAll();
	    }

	    public DotMembre findById(DotMembreID dotMembreID) {
	        return dotMembreRepository.findById(dotMembreID).orElse(null);
	    }

	    public DotMembre addDotMembre(DotMembre dotMemrbe) {
	        return dotMembreRepository.save(dotMemrbe);
	    }
	    public DotMembre updateDotProjet(DotMembreID id, DotMembre dotMembre) {
	    	dotMembre.setDotmembreID(id);
	    	return dotMembreRepository.save(dotMembre);
	    }

	    public void deleteById(DotMembreID dotMembreID) {
	        dotMembreRepository.deleteById(dotMembreID);
	    }
}
