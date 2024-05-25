package bolide.mg.back.controller;

import bolide.mg.back.model.Admin;
import bolide.mg.back.service.AdminService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;

  @GetMapping
  public ResponseEntity<List<Admin>> findAllAdmin() {
    return ResponseEntity.ok(adminService.findAllAdmin());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Admin> findAdminById(@PathVariable Integer id) {
    return ResponseEntity.ok(adminService.findAdminById(id));
  }

  @PutMapping
  public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
    return ResponseEntity.ok(adminService.saveAdmin(admin));
  }

  @PutMapping("/delete")
  public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) {
    return ResponseEntity.ok(adminService.deleteAdmin(admin));
  }
}
