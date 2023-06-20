package ISI.Projet.GestionFinanciereLabo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ISI.Projet.GestionFinanciereLabo.models.Admin;
import ISI.Projet.GestionFinanciereLabo.models.AuthResponse;
import ISI.Projet.GestionFinanciereLabo.models.LoginRequest;
import ISI.Projet.GestionFinanciereLabo.models.Membre;
import ISI.Projet.GestionFinanciereLabo.models.Responsable;
import ISI.Projet.GestionFinanciereLabo.services.AdminService;
import ISI.Projet.GestionFinanciereLabo.services.MembreService;
import ISI.Projet.GestionFinanciereLabo.services.ResponsableService;

@RestController
public class LoginController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private MembreService membreService;
	@Autowired
    private ResponsableService responsableService;

    
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        Admin admin = adminService.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            
            String token = generateToken(admin.getId(), "ADMIN");
            return new ResponseEntity<>(new AuthResponse(token, "ADMIN"), HttpStatus.OK);
        }

        // Find member by email
        Membre member = membreService.findByEmail(email);
        if (member != null && member.getPassword().equals(password)) {
            // Successful login as member
           
            if(member.isDirector()){
                String token = generateToken(member.getId(), "DIRECTOR");
                return new ResponseEntity<>(new AuthResponse(token, "DIRECTOR"), HttpStatus.OK);
            } else
            
            if(!member.isDirector()){
                String token = generateToken(member.getId(), "MEMBRE");
                return new ResponseEntity<>(new AuthResponse(token, "MEMBRE"), HttpStatus.OK);
            } 
            	
            	Responsable responsable = responsableService.findByEmail(email);
            
            if(responsable != null && responsable.getPassword().equals(password)) {
                String token = generateToken(admin.getId(), "RESPONSABLE");
                return new ResponseEntity<>(new AuthResponse(token, "RESPONSABLE"), HttpStatus.OK);
            }
        }

  


        // Invalid login credentials
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    
    }

    private String generateToken(Long id, String role) {
        return role+"+"+id;
    }
    
    
    
}