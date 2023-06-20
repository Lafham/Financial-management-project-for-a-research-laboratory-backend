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

import ISI.Projet.GestionFinanciereLabo.models.Membre;
import ISI.Projet.GestionFinanciereLabo.services.MembreService;

@RestController
@RequestMapping("/membres")
public class MembreController {
	private final MembreService membreService;

    @Autowired
    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    
    @PostMapping
    public ResponseEntity<Membre> addMembre(@RequestBody Membre membre) {
        Membre newMembre = membreService.createMembre(membre);
        return new ResponseEntity<>(newMembre, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> getMembreById(@PathVariable("id") Long id) {
        Membre membre = membreService.getMembreById(id);
        if (membre != null) {
            return new ResponseEntity<>(membre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Membre>> getAllMembres() {
        List<Membre> membres = membreService.getAllMembres();
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membre> updateMembre(@PathVariable("id") Long id, @RequestBody Membre membre) {
        Membre updatedMembre = membreService.updateMembre(id, membre);
        if (updatedMembre != null) {
            return new ResponseEntity<>(updatedMembre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembre(@PathVariable("id") Long id) {
        membreService.deleteMembre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
}
