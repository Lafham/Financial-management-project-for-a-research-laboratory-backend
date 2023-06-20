package ISI.Projet.GestionFinanciereLabo.controller;

import java.util.List;

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

import ISI.Projet.GestionFinanciereLabo.models.DotationUcaRech;
import ISI.Projet.GestionFinanciereLabo.services.DotationUcaRechService;

@RestController
@RequestMapping("/dotations")
public class DotationUcaRechController {

    private final DotationUcaRechService dotationUcaRechService;

    public DotationUcaRechController(DotationUcaRechService dotationUcaRechService) {
        this.dotationUcaRechService = dotationUcaRechService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DotationUcaRech> getDotationUcaRechById(@PathVariable Long id) {
        DotationUcaRech dotationUcaRech = dotationUcaRechService.findById(id);
        return ResponseEntity.ok(dotationUcaRech);
    }

    @GetMapping
    public ResponseEntity<List<DotationUcaRech>> getAllDotationUcaRech() {
        List<DotationUcaRech> dotations = dotationUcaRechService.findAll();
        return ResponseEntity.ok(dotations);
    }

    @PostMapping
    public ResponseEntity<DotationUcaRech> createDotationUcaRech(@RequestBody DotationUcaRech dotationUcaRech) {
        DotationUcaRech createdDotation = dotationUcaRechService.addDotationUcaRech(dotationUcaRech);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDotation);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DotationUcaRech> updateMembre(@PathVariable("id") Long id, @RequestBody DotationUcaRech dotationUcaRech) {
    	DotationUcaRech updatedDotationUcaRech = dotationUcaRechService.updateDotationUcaRech(id, dotationUcaRech);
        if (updatedDotationUcaRech != null) {
            return new ResponseEntity<>(updatedDotationUcaRech, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDotationUcaRech(@PathVariable Long id) {
        dotationUcaRechService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

