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

import ISI.Projet.GestionFinanciereLabo.models.Responsable;
import ISI.Projet.GestionFinanciereLabo.services.ResponsableService;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @PostMapping
    public Responsable createResponsable(@RequestBody Responsable responsable) {
        return responsableService.createResponsable(responsable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsable> getResponsableById(@PathVariable("id") Long id) {
        Responsable responsable = responsableService.getResponsableById(id);
        if (responsable != null) {
            return new ResponseEntity<>(responsable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Responsable> getAllResponsables() {
        return responsableService.getAllResponsables();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsable> updateResponsable(@PathVariable Long id, @RequestBody Responsable responsable) {
        Responsable updatedResponsable = responsableService.updateResponsable(id, responsable);
        if (updatedResponsable != null) {
        	return ResponseEntity.ok(updatedResponsable);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponsable(@PathVariable("id") Long id) {
    	responsableService.deleteResponsable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
