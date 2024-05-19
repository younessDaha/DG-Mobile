package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.Cart;
import ma.xproce.emobile.dao.entities.Telephone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface CartService {
    Cart ajouteraupanier(Integer produitId);

    List<Cart> getProduitsDansLePanier();
//    Cart ajouterTeleAuPanier(Integer id , Integer userId);
//
//    Cart ajouterAccToPanier(Integer id, Integer userId);
//
//    List<Cart> getProduitsDansLePanier();
//    Cart findAll();
//
//    void addTelToCart(Integer id);

//    List<Cart> getAllCarts();
//
//    Optional<Cart> findByUserId(Integer userId);

//    void ajouteraupanier(Integer produitId);


//    void ajouterAuPanier(Integer cid, Integer id);
//
//    Optional<Cart> getCardById(Integer cid);
}
