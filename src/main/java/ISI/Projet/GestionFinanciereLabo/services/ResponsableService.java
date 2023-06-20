package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.Responsable;
import ISI.Projet.GestionFinanciereLabo.repositories.ResponsableRepository;

@Service
public class ResponsableService {

    @Autowired
    private ResponsableRepository responsableRepository;

    public Responsable createResponsable(Responsable responsable) {
        return responsableRepository.save(responsable);
    }

    public Responsable getResponsableById(Long id) {
        return responsableRepository.findById(id).orElse(null);
    }

    public List<Responsable> getAllResponsables() {
        return responsableRepository.findAll();
    }

    public Responsable updateResponsable(Long id ,Responsable responsable) {
    	responsable.setId(id);
        return responsableRepository.save(responsable);
    }

    public void deleteResponsable(Long id) {
        responsableRepository.deleteById(id);
    }

	public Responsable findByEmail(String email) {
		return responsableRepository.findByEmail(email);
	}
}
