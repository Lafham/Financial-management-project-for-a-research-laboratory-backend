package ISI.Projet.GestionFinanciereLabo.controller;

import java.util.List;
import java.util.Optional;

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

import ISI.Projet.GestionFinanciereLabo.models.Etablissement;
import ISI.Projet.GestionFinanciereLabo.services.EtablissementService;

@RestController
@RequestMapping("/etablissements")
//@CrossOrigin(origins = "http://localhost:4200")
public class EtablissementController {

    private EtablissementService etablissementService;

    @Autowired
    public EtablissementController(EtablissementService etablissementService) {
        this.etablissementService = etablissementService;
    }

    @PostMapping
    public ResponseEntity<Etablissement> createEtablissement(@RequestBody Etablissement etablissement) {
        Etablissement createdEtablissement = etablissementService.createEtablissement(etablissement);
        return new ResponseEntity<>(createdEtablissement, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etablissement> getEtablissementById(@PathVariable("id") Long id) {
        Optional<Etablissement> etablissement = etablissementService.getEtablissementById(id);
        return etablissement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<List<Etablissement>> getAllEtablissements() {
        List<Etablissement> etablissements = etablissementService.getAllEtablissements();
        return new ResponseEntity<>(etablissements, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etablissement> updateEtablissement(@PathVariable("id") Long id, @RequestBody Etablissement etablissement) {
        Optional<Etablissement> existingEtablissement = etablissementService.getEtablissementById(id);
        if (existingEtablissement.isPresent()) {
            etablissement.setId(id);
            Etablissement updatedEtablissement = etablissementService.updateEtablissement(id, etablissement);
            return new ResponseEntity<>(updatedEtablissement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtablissementById(@PathVariable("id") Long id) {
    	etablissementService.deleteEtablissementById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
