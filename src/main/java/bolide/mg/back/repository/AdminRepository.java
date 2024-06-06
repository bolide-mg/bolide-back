package bolide.mg.back.repository;

import bolide.mg.back.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
  Admin findByEmailIgnoreCase(String email);
}
