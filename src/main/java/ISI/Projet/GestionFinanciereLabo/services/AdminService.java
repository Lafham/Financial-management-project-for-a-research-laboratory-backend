package ISI.Projet.GestionFinanciereLabo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISI.Projet.GestionFinanciereLabo.models.Admin;
import ISI.Projet.GestionFinanciereLabo.repositories.AdminRepository;

@Service
public class AdminService {

private final AdminRepository adminRepo;
	
	@Autowired
    public AdminService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }
	public Admin createAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	public Admin getAdminById(Long id) {
		return adminRepo.findById(id).orElse(null);
	}
	public List<Admin> getAllAdmins(){
		return adminRepo.findAll();
	}
    public Admin updateAdmin(Long id, Admin admin ) {
    	admin.setId(id);
        return adminRepo.save(admin);
    }

    public void deleteAdmin(Long id) {
    	adminRepo.deleteById(id);
    }
    public Admin findByEmail(String email) {
    	return adminRepo.findByEmail(email);
    }
}
