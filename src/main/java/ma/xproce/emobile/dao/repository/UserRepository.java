package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Page<User> findByNomContaining(String keyword, Pageable pageable);

    Optional<User> findByNom(String username);
}
