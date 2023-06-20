package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.TypeBesoin;
import ISI.Projet.GestionFinanciereLabo.repositories.TypeBesoinRepository;

@Service
public class TypeBesoinService {
    private final TypeBesoinRepository typeBesoinRepository;

    public TypeBesoinService(TypeBesoinRepository typeBesoinRepository) {
        this.typeBesoinRepository = typeBesoinRepository;
    }

    public TypeBesoin addTypeBesoin(TypeBesoin typeBesoin) {
        return typeBesoinRepository.save(typeBesoin);
    }

    public TypeBesoin getTypeBesoinById(Long id) {
        return typeBesoinRepository.findById(id).orElse(null);
    }

    public List<TypeBesoin> getAllTypeBesoins() {
        return typeBesoinRepository.findAll();
    }

    public TypeBesoin updateTypeBesoin(Long id, TypeBesoin typeBesoin) {
    	typeBesoin.setId(id);
    	return typeBesoinRepository.save(typeBesoin);
    }
    
    public void deleteTypeBesoin(Long id) {
        typeBesoinRepository.deleteById(id);
    }
}
