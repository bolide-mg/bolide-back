package bolide.mg.back.controller;

import bolide.mg.back.model.Admin;
import bolide.mg.back.model.AdminDto;
import bolide.mg.back.service.AdminService;
import bolide.mg.back.service.TokenService;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;
  private final TokenService tokenService;

  private final AuthenticationManager authenticationManager;

  @GetMapping
  public ResponseEntity<List<Admin>> findAllAdmin(HttpServletResponse response) {
    List<Admin> admins = adminService.findAllAdmin();
    response.setHeader("X-Total-Count", String.valueOf(admins.size()));
    return ResponseEntity.ok(admins);
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
  public ResponseEntity<Map<String, Object>> signin(@RequestBody Admin admin) {
    Admin existingAdmin = adminService.findAdminByEmail(admin.getEmail());
    if (existingAdmin == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin doesn't exist");
    }
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword()));
    String token = tokenService.generateToken(authentication);

    AdminDto adminDto =
        new AdminDto(existingAdmin.getId(), existingAdmin.getEmail(), existingAdmin.getName());

    return ResponseEntity.ok(Map.of("token", token, "admin", adminDto));
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) {
    return ResponseEntity.ok(adminService.deleteAdmin(admin));
  }
}
