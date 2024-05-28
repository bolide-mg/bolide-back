package bolide.mg.back.config;

import bolide.mg.back.model.Admin;
import bolide.mg.back.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final AdminRepository adminRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Admin admin = adminRepository.findByEmail(email);
    if (admin == null) {
      throw new UsernameNotFoundException(email + " not found");
    }
    return new UserDetailsImpl(admin);
  }
}
