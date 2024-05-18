package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.Cart;
import ma.xproce.emobile.dao.entities.Telephone;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface CartService {
    Cart findAll();

    void addTelToCart(Integer id);


//    void ajouterAuPanier(Integer cid, Integer id);
//
//    Optional<Cart> getCardById(Integer cid);
}
