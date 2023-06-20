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

import ISI.Projet.GestionFinanciereLabo.models.ExpBesoins;
import ISI.Projet.GestionFinanciereLabo.services.ExpBesoinsService;

@RestController
@RequestMapping("/expbesoins")
public class ExpBesoinsController {

    private final ExpBesoinsService expBesoinsService;

    public ExpBesoinsController(ExpBesoinsService expBesoinsService) {
        this.expBesoinsService = expBesoinsService;
    }

    // Endpoint pour créer un nouvel ExpBesoins
    @PostMapping
    public ResponseEntity<ExpBesoins> createExpBesoins(@RequestBody ExpBesoins expBesoins) {
        ExpBesoins createdExpBesoins = expBesoinsService.createExpBesoins(expBesoins);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpBesoins);
    }

    // Endpoint pour récupérer tous les ExpBesoins
    @GetMapping
    public ResponseEntity<List<ExpBesoins>> getAllExpBesoins() {
        List<ExpBesoins> expBesoinsList = expBesoinsService.getAllExpBesoins();
        return ResponseEntity.ok(expBesoinsList);
    }

    // Endpoint pour récupérer un ExpBesoins par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ExpBesoins> getExpBesoinsById(@PathVariable("id") Long id) {
        ExpBesoins expBesoins = expBesoinsService.getExpBesoinsById(id);
        return ResponseEntity.ok(expBesoins);
    }

    // Endpoint pour mettre à jour un ExpBesoins existant
    @PutMapping("/{id}")
    public ResponseEntity<ExpBesoins> updateExpBesoins(@PathVariable("id") Long id, @RequestBody ExpBesoins expBesoins) {
        ExpBesoins updatedExpBesoins = expBesoinsService.updateExpBesoins(id, expBesoins);
        return ResponseEntity.ok(updatedExpBesoins);
    }

    // Endpoint pour supprimer un ExpBesoins par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpBesoins(@PathVariable("id") Long id) {
        expBesoinsService.deleteExpBesoins(id);
        return ResponseEntity.noContent().build();
    }
}

