package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Product;
import ma.xproce.emobile.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findRoleByNom(String user);
}
