package bolide.mg.back.controller;

import bolide.mg.back.model.Admin;
import bolide.mg.back.service.AdminService;
import bolide.mg.back.service.TokenService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;
  private final TokenService tokenService;

  private final AuthenticationManager authenticationManager;

  @GetMapping
  public ResponseEntity<List<Admin>> findAllAdmin() {
    return ResponseEntity.ok(adminService.findAllAdmin());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Admin> findAdminById(@PathVariable Integer id) {
    return ResponseEntity.ok(adminService.findAdminById(id));
  }

  @PutMapping("/signup")
  public ResponseEntity<Admin> signup(@RequestBody Admin admin) {
    return ResponseEntity.ok(adminService.saveAdmin(admin));
  }

  @PutMapping("/signin")
  public ResponseEntity<String> signin(@RequestBody Admin admin) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword()));
    return ResponseEntity.ok(tokenService.generateToken(authentication));
  }

  @PutMapping("/delete")
  public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) {
    return ResponseEntity.ok(adminService.deleteAdmin(admin));
  }
}
