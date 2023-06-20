package ISI.Projet.GestionFinanciereLabo.services;

import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.Laboratoire;
import ISI.Projet.GestionFinanciereLabo.repositories.LaboratoireRepository;
import ISI.Projet.GestionFinanciereLabo.repositories.MembreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service @AllArgsConstructor
public class LaboratoireService {

	 private final LaboratoireRepository laboratoireRepository;


	    public Laboratoire addLaboratoire(Laboratoire laboratoire) {
	        return laboratoireRepository.save(laboratoire);
	    }

	    public Laboratoire getLaboratoireById(Long id) {
	        return laboratoireRepository.findById(id).orElse(null);
	    }

	    public Set<Laboratoire> getAllLaboratoires() {
	    	return new HashSet<>(laboratoireRepository.findAll());
	    }

	    public void deleteLaboratoireById(Long id) {
	    	Laboratoire labo = laboratoireRepository.findById(id).orElse(null);
	    	if(labo!= null) {
	    		labo.getMembres().stream().forEach(m->m.setLaboratoire(null));
	    	}
	        laboratoireRepository.deleteById(id);
	    }
	    
	    public Laboratoire updateLaboratoire(Long id, Laboratoire laboratoire) {
	    	Laboratoire labo = laboratoireRepository.findById(id).orElse(null);
	    	labo.setId(id);
	    	labo.setMembres(laboratoire.getMembres());
	    	labo.setEtablissement(laboratoire.getEtablissement());
	    	return laboratoireRepository.save(labo);
	    }
}
