package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Cart;
import ma.xproce.emobile.dao.entities.Product;
import ma.xproce.emobile.dao.entities.Telephone;
import ma.xproce.emobile.dao.repository.CartRepository;
import ma.xproce.emobile.dao.repository.TelephoneRepository;
import ma.xproce.emobile.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CartServiceImp implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Override
    public Cart findAll() {
        return (Cart) cartRepository.findAll();
    }

    @Override
    public void addTelToCart(Integer id) {
        Optional<Telephone> optionalTelephone = telephoneRepository.findById(id);
        if (optionalTelephone.isPresent()) {
            Telephone telephone = optionalTelephone.get();
            Cart cart = new Cart();
            cart.getProducts().add(telephone);
            cartRepository.save(cart);
        } else {
            throw new RuntimeException("Téléphone non trouvé");
        }
    }


//    @Override
//    public void ajouterAuPanier(Integer cid, Integer id) {
//        Cart panier = cartRepository.findById(cid).orElseThrow();
//        Telephone telephone = telephoneRepository.findById(id).orElseThrow();
//
//        panier.getProducts().add(telephone);
//
//    }
//
//    public Optional<Cart> getCardById(Integer cid) {
//        return cartRepository.findById(cid);
//    }
}
