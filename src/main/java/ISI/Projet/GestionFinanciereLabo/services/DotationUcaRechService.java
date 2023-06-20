package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.DotationUcaRech;
import ISI.Projet.GestionFinanciereLabo.repositories.DotationUcaRechRepository;

@Service
public class DotationUcaRechService {

    private final DotationUcaRechRepository dotationUcaRechRepository;

    public DotationUcaRechService(DotationUcaRechRepository dotationUcaRechRepository) {
        this.dotationUcaRechRepository = dotationUcaRechRepository;
    }

    public DotationUcaRech findById(Long id) {
        return dotationUcaRechRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("DotationUcaRech not found with id: " + id));
    }

    public List<DotationUcaRech> findAll() {
        return dotationUcaRechRepository.findAll();
    }

    public DotationUcaRech addDotationUcaRech(DotationUcaRech dotationUcaRech) {
        return dotationUcaRechRepository.save(dotationUcaRech);
    }
    
    public DotationUcaRech updateDotationUcaRech(Long id, DotationUcaRech dotationUcaRech) {
    	dotationUcaRech.setId(id);
        return dotationUcaRechRepository.save(dotationUcaRech);
    }
    
    public void deleteById(Long id) {
        dotationUcaRechRepository.deleteById(id);
    }
}

