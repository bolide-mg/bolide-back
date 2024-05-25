package bolide.mg.back.service;

import bolide.mg.back.model.Admin;
import bolide.mg.back.repository.AdminRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  private final AdminRepository adminRepository;

  public AdminService(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  public List<Admin> findAllAdmin() {
    return adminRepository.findAll();
  }

  public Admin findAdminById(Integer id) {
    return adminRepository.findById(id).orElse(null);
  }

  public Admin saveAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  public Admin deleteAdmin(Admin admin) {
    Admin currentAdmin = findAdminById(admin.getId());
    adminRepository.delete(admin);
    return currentAdmin;
  }
}