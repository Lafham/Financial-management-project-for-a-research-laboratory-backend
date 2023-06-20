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

import ISI.Projet.GestionFinanciereLabo.models.DotProjet;
import ISI.Projet.GestionFinanciereLabo.models.DotProjetID;
import ISI.Projet.GestionFinanciereLabo.services.DotProjetService;

@RestController
@RequestMapping("/dotprojets")
public class DotProjetController {
    private final DotProjetService dotProjetService;

    @Autowired
    public DotProjetController(DotProjetService dotProjetService) {
        this.dotProjetService = dotProjetService;
    }

    @GetMapping
    public ResponseEntity<List<DotProjet>> getAllProjets() {
        List<DotProjet> dotProjet = dotProjetService.findAll();
        return ResponseEntity.ok(dotProjet);
    }
    
    @GetMapping("/{membreId}/{projetId}")
    public ResponseEntity<DotProjet> getDotProjetById(@PathVariable("membreId") Long membreId, @PathVariable("projetId") Long projetId) {
    	DotProjetID dotProjetId = new DotProjetID(membreId, projetId);
        DotProjet dotProjet = dotProjetService.findById(dotProjetId);
        if (dotProjet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dotProjet);
    }

    @PostMapping
    public ResponseEntity<DotProjet> createDotProjet(@RequestBody DotProjet dotProjet) {
        DotProjet createdDotProjet = dotProjetService.addDotProjet(dotProjet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDotProjet);
    }
    @PutMapping("/{membreId}/{projetId}")
    public ResponseEntity<DotProjet> updateDotProjet(@PathVariable("membreId") Long membreId, @PathVariable("projetId") Long projetId, @RequestBody DotProjet dotProjet) {
    	DotProjetID dotProjetID = new DotProjetID(membreId, projetId);
    	DotProjet updatedDotProjet = dotProjetService.updateDotProjet(dotProjetID, dotProjet);
        if (updatedDotProjet != null) {
        	return ResponseEntity.ok(updatedDotProjet);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{membreId}/{projetId}")
    public ResponseEntity<Void> deleteProjet(@PathVariable("membreId") Long membreId, @PathVariable("projetId") Long projetId) {
    	DotProjetID dotProjetId = new DotProjetID(membreId, projetId);
        DotProjet dotProjet = dotProjetService.findById(dotProjetId);
        if (dotProjet == null) {
            return ResponseEntity.notFound().build();
        }
        dotProjetService.deleteById(dotProjetId);
        return ResponseEntity.noContent().build();
    }
}
