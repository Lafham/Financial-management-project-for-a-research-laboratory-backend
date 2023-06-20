package ISI.Projet.GestionFinanciereLabo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISI.Projet.GestionFinanciereLabo.models.Projet;
import ISI.Projet.GestionFinanciereLabo.services.ProjetService;

@RestController
@RequestMapping("/projets")
public class ProjetController {
    private final ProjetService projetService;

    @Autowired
    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @GetMapping
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> projets = projetService.findAll();
        return ResponseEntity.ok(projets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable("id") Long id) {
        Projet projet = projetService.findById(id);
        if (projet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projet);
    }

    @PostMapping
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        Projet createdProjet = projetService.addProjet(projet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProjet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable("id") Long id, @RequestBody Projet projet) {
    	Projet updatedProjet = projetService.updateProjet(id, projet);
        if (updatedProjet != null) {
        	return ResponseEntity.ok(updatedProjet);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable("id") Long id) {
        Projet projet = projetService.findById(id);
        if (projet == null) {
            return ResponseEntity.notFound().build();
        }
        projetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
