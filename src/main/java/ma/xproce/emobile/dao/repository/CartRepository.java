package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Cart;
import ma.xproce.emobile.dao.entities.Telephone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("SELECT c FROM Cart c WHERE c.user.id = ?1")
    Cart findActiveCart(Integer userId);

//    Cart addProduct(Telephone telephone);

//    Optional<Cart> findByUserId(Integer userId);
}
