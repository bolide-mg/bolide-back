package bolide.mg.back.controller;

import bolide.mg.back.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
  private final TokenService tokenService;

  @PostMapping("/token")
  public String token(Authentication authentication) {
    return tokenService.generateToken(authentication);
  }
}
