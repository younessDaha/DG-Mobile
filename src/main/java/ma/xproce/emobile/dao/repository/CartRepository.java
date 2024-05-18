package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
