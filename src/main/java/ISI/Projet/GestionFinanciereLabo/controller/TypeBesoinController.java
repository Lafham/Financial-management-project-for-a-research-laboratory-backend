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

import ISI.Projet.GestionFinanciereLabo.models.TypeBesoin;
import ISI.Projet.GestionFinanciereLabo.services.TypeBesoinService;

@RestController
@RequestMapping("/typesbesoins")
public class TypeBesoinController {
    private final TypeBesoinService typeBesoinService;

    public TypeBesoinController(TypeBesoinService typeBesoinService) {
        this.typeBesoinService = typeBesoinService;
    }

    @PostMapping
    public TypeBesoin createTypeBesoin(@RequestBody TypeBesoin typeBesoin) {
        return typeBesoinService.addTypeBesoin(typeBesoin);
    }

    @GetMapping("/{id}")
    public TypeBesoin getTypeBesoinById(@PathVariable Long id) {
        return typeBesoinService.getTypeBesoinById(id);
    }

    @GetMapping
    public List<TypeBesoin> getAllTypeBesoins() {
        return typeBesoinService.getAllTypeBesoins();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeBesoin> updateTypeBesoin(@PathVariable Long id, @RequestBody TypeBesoin typeBesoin) {
    	TypeBesoin updatedTypeBesoin = typeBesoinService.updateTypeBesoin(id, typeBesoin);
        if (updatedTypeBesoin != null) {
        	return ResponseEntity.ok(updatedTypeBesoin);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeBesoin(@PathVariable("id") Long id) {
    	typeBesoinService.deleteTypeBesoin(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

