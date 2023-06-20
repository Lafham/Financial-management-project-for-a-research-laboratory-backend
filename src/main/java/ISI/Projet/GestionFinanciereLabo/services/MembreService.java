package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.Membre;
import ISI.Projet.GestionFinanciereLabo.repositories.MembreRepository;

@Service
public class MembreService {
	private final MembreRepository membreRepo;
	
	@Autowired
    public MembreService(MembreRepository membreRepository) {
        this.membreRepo = membreRepository;
    }
	public Membre createMembre(Membre membre) {
		return membreRepo.save(membre);
	}
	public Membre getMembreById(Long id) {
		return membreRepo.findById(id).orElse(null);
	}
	public List<Membre> getAllMembres(){
		return membreRepo.findAll();
	}
    public Membre updateMembre(Long id, Membre membre ) {
    	membre.setId(id);
        return membreRepo.save(membre);
    }

    public void deleteMembre(Long id) {
        membreRepo.deleteById(id);
    }
	public Membre findByEmail(String email) {
		return membreRepo.findByEmail(email);
	}
    
	

}
