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

import ISI.Projet.GestionFinanciereLabo.models.DotMembre;
import ISI.Projet.GestionFinanciereLabo.models.DotMembreID;
import ISI.Projet.GestionFinanciereLabo.services.DotMembreService;

@RestController
@RequestMapping("/dotmembres")
public class DotMembreController {

    private final DotMembreService dotMembreService;

    @Autowired
    public DotMembreController(DotMembreService dotMembreService) {
        this.dotMembreService = dotMembreService;
    }

    @GetMapping
    public ResponseEntity<List<DotMembre>> getAllProjets() {
        List<DotMembre> dotMembre = dotMembreService.findAll();
        return ResponseEntity.ok(dotMembre);
    }
    
    @GetMapping("/{membreId}/{dotationId}")
    public ResponseEntity<DotMembre> getDotMembreById(@PathVariable("membreId") Long membreId, @PathVariable("dotationId") Long dotationId) {
    	DotMembreID dotMembreId = new DotMembreID(membreId, dotationId);
    	DotMembre dotMemrbe = dotMembreService.findById(dotMembreId);
        if (dotMemrbe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dotMemrbe);
    }

    @PostMapping
    public ResponseEntity<DotMembre> createDotProjet(@RequestBody DotMembre dotMembre) {
        DotMembre createdDotMembre = dotMembreService.addDotMembre(dotMembre);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDotMembre);
    }
    @PutMapping("/{membreId}/{dotationId}")
    public ResponseEntity<DotMembre> updateDotProjet(@PathVariable("membreId") Long membreId, @PathVariable("dotationId") Long dotationId, @RequestBody DotMembre dotMembre) {
    	DotMembreID dotMembreID = new DotMembreID(membreId, dotationId);
    	DotMembre updatedDotMembre = dotMembreService.updateDotProjet(dotMembreID, dotMembre);
        if (updatedDotMembre != null) {
        	return ResponseEntity.ok(updatedDotMembre);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{membreId}/{dotationId}")
    public ResponseEntity<Void> deleteMembre(@PathVariable("membreId") Long membreId, @PathVariable("dotationId") Long dotationId) {
    	DotMembreID dotMembreId = new DotMembreID(membreId, dotationId);
    	DotMembre dotMemrbe = dotMembreService.findById(dotMembreId);
        if (dotMemrbe == null) {
            return ResponseEntity.notFound().build();
        }
        dotMembreService.deleteById(dotMembreId);
        return ResponseEntity.noContent().build();
    }
}

