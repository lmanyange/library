package za.co.absa.nnw.library.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.absa.nnw.library.entity.security.Role;
import za.co.absa.nnw.library.enums.security.ERole;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
