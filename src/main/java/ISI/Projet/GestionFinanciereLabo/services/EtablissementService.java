package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.Etablissement;
import ISI.Projet.GestionFinanciereLabo.repositories.EtablissementRepository;
import ISI.Projet.GestionFinanciereLabo.repositories.LaboratoireRepository;

@Service
public class EtablissementService {

	private EtablissementRepository etablissementRepository;
	private LaboratoireRepository laboRepo;

	@Autowired
	public EtablissementService(EtablissementRepository etablissementRepository) {
		this.etablissementRepository = etablissementRepository;
	}

	public Etablissement createEtablissement(Etablissement etablissement) {
		return etablissementRepository.save(etablissement);
	}

	public Optional<Etablissement> getEtablissementById(Long id) {
		return etablissementRepository.findById(id);
	}

	public List<Etablissement> getAllEtablissements() {
		return etablissementRepository.findAll();
	}

	public Etablissement updateEtablissement(Long id, Etablissement etablissement) {
		etablissement.setId(id);
		return etablissementRepository.save(etablissement);
	}

	public void deleteEtablissementById(Long id) {
		Etablissement etablissement = etablissementRepository.findById(id).get();
		etablissement.getLaboratoires().stream().forEach(lab->laboRepo.deleteById(id));
		etablissementRepository.deleteById(id);
	}

}
