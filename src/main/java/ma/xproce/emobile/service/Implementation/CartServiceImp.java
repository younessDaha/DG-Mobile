package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.*;
import ma.xproce.emobile.dao.repository.*;
import ma.xproce.emobile.service.CartService;
import ma.xproce.emobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CartServiceImp implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private TelephoneRepository telephoneRepository;
    @Autowired
    private AccesoirRepository accesoirRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    private final List<Cart> panierList = new ArrayList<>();

    @Override
    public Cart ajouteraupanier(Integer productId) {
        Product product=productRepository.findById(productId).get();
        if(product!=null){
            Cart cart=new Cart(product);
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public List<Cart> getProduitsDansLePanier() {
        return cartRepository.findAll();
    }
}


//    @Override
//    public Cart ajouterTeleAuPanier(Integer id, Integer userId) {
//        Optional<Telephone> telephoneOpt = telephoneRepository.findById(id);
//        if (telephoneOpt.isPresent()) {
//            Telephone telephone = telephoneOpt.get();
//            Cart cart = cartRepository.findActiveCart(userId);
//
//            if (cart == null) {
//                cart = new Cart();
//                Optional<User> user = userRepository.findById(userId);
//                cart.setUser(user.get()); // Assurez-vous d'assigner le panier à l'utilisateur
//            }
//
//            // Vérifier si le produit est déjà dans le panier
//            boolean alreadyInCart = cart.getTelephones().stream()
//                    .anyMatch(telephone1 -> telephone1.getId().equals(telephone.getId()));
//            if (!alreadyInCart) {
//                cart.getTelephones().add(telephone);
//            }
//
//            return cartRepository.save(cart);
//        } else {
//            throw new RuntimeException("Téléphone non trouvé");
//        }
//    }


//    @Override
//    public Cart ajouterAccToPanier(Integer id, Integer userId) {
//        Optional<Accesoir> accesoirOpt = accesoirRepository.findById(id);
//        if(accesoirOpt.isPresent()){
//            Accesoir accesoir = accesoirOpt.get();
//            Cart cart = cartRepository.findActiveCart(userId); // Supposez que vous avez une méthode pour obtenir le panier actif de l'utilisateur
//            if (cart == null) {
//                cart = new Cart();
//            }
//
////            cart = cartRepository.addProduct(telephone);
//            cart.getProducts().add((Product) accesoir);
//            return cartRepository.save(cart);
//        } else {
//            throw new RuntimeException("Téléphone non trouvé");
//        }
//        }
//
//    @Override
//    public List<Cart> getProduitsDansLePanier() {
//        return cartRepository.findAll();
//    }




//    @Autowired
//
//    @Override
//    public void ajouteraupanier(Integer produitId) {
//
//    }

//    @Override
//    public Cart findAll() {
//        return (Cart) cartRepository.findAll();
//    }
//
//    @Override
//    public void addTelToCart(Integer id) {
//        Optional<Telephone> optionalTelephone = telephoneRepository.findById(id);
//        if (optionalTelephone.isPresent()) {
//            Telephone telephone = optionalTelephone.get();
//            Cart cart = new Cart();
//            cart.getProducts().add(telephone);
//            cartRepository.save(cart);
//        } else {
//            throw new RuntimeException("Téléphone non trouvé");
//        }
//    }
//
//    @Override
//    public List<Cart> getAllCarts() {
//        return cartRepository.findAll();
//    }
    //    @Override
//    public void ajouteraupanier(Integer produitId) {
//
//    }

//    @Override
//    public Optional<Cart> findByUserId(Integer userId) {
//        return cartRepository.findByUserId(userId);
//    }




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

