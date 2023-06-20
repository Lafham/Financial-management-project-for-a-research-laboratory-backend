package ISI.Projet.GestionFinanciereLabo.controller;

import java.util.Set;

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

import ISI.Projet.GestionFinanciereLabo.models.Laboratoire;
import ISI.Projet.GestionFinanciereLabo.services.LaboratoireService;

@RestController
@RequestMapping("/laboratoires")
public class LaboratoireController {

    private final LaboratoireService laboratoireService;

    @Autowired
    public LaboratoireController(LaboratoireService laboratoireService) {
        this.laboratoireService = laboratoireService;
    }

    @PostMapping
    public ResponseEntity<Laboratoire> addLaboratoire(@RequestBody Laboratoire laboratoire) {
        Laboratoire newLaboratoire = laboratoireService.addLaboratoire(laboratoire);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLaboratoire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratoire> updateLaboratoire( @PathVariable("id") Long id, @RequestBody Laboratoire laboratoireDetails) {
        Laboratoire updatedLaboratoire = laboratoireService.updateLaboratoire(id, laboratoireDetails);
        if (updatedLaboratoire != null) {
            return ResponseEntity.ok(updatedLaboratoire);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable("id") Long id) {
        Laboratoire laboratoire = laboratoireService.getLaboratoireById(id);
        if (laboratoire != null) {
            return ResponseEntity.ok(laboratoire);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Set<Laboratoire>> getAllLaboratoires() {
        Set<Laboratoire> laboratoires = laboratoireService.getAllLaboratoires();
        return ResponseEntity.ok(laboratoires);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratoireById(@PathVariable("id") Long id) {
        laboratoireService.deleteLaboratoireById(id);
        return ResponseEntity.noContent().build();
    }

}
