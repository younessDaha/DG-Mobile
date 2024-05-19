package ma.xproce.emobile.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ma.xproce.emobile.dao.entities.*;
import ma.xproce.emobile.dao.repository.ProductRepository;
import ma.xproce.emobile.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class CartControlleur {
    @Autowired
    private CartService cartService;
    @Autowired
    private TelephoneService telephoneService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;

//    @GetMapping("/cart")
//    public String afficherPanier(@PathVariable Integer cid, Model model) {
//        Optional<Cart> panier = cartService.getCardById(cid);
//        model.addAttribute("panier", panier);
//        return "cart";
//    }
//
//    // Ajoute un téléphone au panier
//    @PostMapping("/cart/{cid}")
//    public String ajouterTelephoneAuPanier(@PathVariable Integer cid, @RequestParam Integer id) {
//        cartService.ajouterAuPanier(cid, id);
//        return "redirect:/cart/{cid}";
//    }
//    @GetMapping("/cart")
//    public String afficherCart(Model model){
//        Cart cart = cartService.findAll();
//        model.addAttribute("cart",cart);
//        return "cart";
//    }
//
//    @PostMapping("/cart/{id}")
//    public String ajouterProToCar(@PathVariable Integer id){
//        cartService.addTelToCart(id);
//        return "/redirect:telephoneList";
//    }

//    @GetMapping("/cartlist")
//    public String getAllCarts(Model model) {
//        List<Cart> carts = cartService.getAllCarts();
//        model.addAttribute("cart",carts);
//        return "cartlist";
//    }
//
//    @CrossOrigin("*")
//    @GetMapping("/cart/{userId}")
//    public String getCartByUserId(@PathVariable("userId") Integer userId,Model model) {
//        Optional<Cart> cartOptional = cartService.findByUserId(userId);
//        Collection<Product> products = cartOptional.get().getProducts();
//        model.addAttribute("cart",products);
//        return "cartlistuser";
//    }
//
//    @PostMapping("/cartadd/{userId}")
//    public  ResponseEntity<Cart> addToCart(@PathVariable Integer userId ,@RequestBody Integer produitId){
//        User user =userService.getUserById(userId);
//
//        System.out.println("----------------------------------------------------");
//        System.out.println(user);
//        System.out.println("----------------------------------------------------");
//
//        Cart cart= user.getCart();
//        System.out.println("----------------------------------------------------");
//        System.out.println(user.getCart());
//        System.out.println("----------------------------------------------------");
//        if (user.getCart()!=null){
//            cart.getProducts().add(productService.getProductById(produitId));
//            cart.setQuantite(cart.getMangas().size());
//            user.setCart(cart);
//            userServices.saveUser(user);
//            cartServices.addToCart(cart);
//            return new ResponseEntity<>(cart, HttpStatus.CREATED);
//        }
//        Cart cart1 = new Cart();
//        user.setId(user.getId());
//        cart1.setUser(user);
//        cart1.setMangas(List.of(mangaService.getMangaById(mangaID)));
//        cart1.setQuantity(cart1.getMangas().size());
//        cartServices.addToCart(cart1);
//        user.setCart(cart1);
//        return new ResponseEntity<>(cart1, HttpStatus.CREATED);
//    }

//    @GetMapping("/addTeleCart/{id}")
//    public String ajouterAuPanier(@PathVariable("id") Integer id, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
//        // Récupérer l'ID de l'utilisateur depuis la session
//        String username =  userDetails.getUsername();
//        Optional<User> user = userService.getUserByNom(username);
//        Integer userId = user.get().getId();
//
//        // Récupérer l'URL de la page référente
//        String referer = request.getHeader("Referer");
//
//        // Vérifier la page référente et ajouter le produit au panier en conséquence
//        if (referer != null) {
//            if (referer.contains("/telephone")) {
//                cartService.ajouterTeleAuPanier(id, userId);
//                return "redirect:/telephone/{id}";
//            } else if (referer.contains("/accessoir")) {
//                cartService.ajouterAccToPanier(id, userId);
//                return "redirect:/accessoir";
//            }
//        }
//
//        // Rediriger vers la page d'accueil par défaut
//        return "redirect:/home";
//    }
//
//
//
//    @GetMapping("/cart")
//    public String afficherPanier(Model model) {
//        List<Cart> listeDesProduitsDansLePanier = cartService.getProduitsDansLePanier();
//        double prixTotal = 0.0; // Initialisez le prix total à zéro
//
//        // Log pour vérifier les produits récupérés
//        System.out.println("Produits dans le panier: " + listeDesProduitsDansLePanier);
//
//        // Parcourir chaque objet Cart dans la liste
//        for (Cart cart : listeDesProduitsDansLePanier) {
//            // Obtenez la liste des produits de chaque objet Cart
//            List<Product> products = (List<Product>) cart.getProducts();
//
//            // Log pour vérifier les produits de chaque Cart
//            System.out.println("Produits dans le cart " + cart.getCid() + ": " + products);
//
//            // Parcourir chaque produit dans la liste des produits
//            for (Product product : products) {
//                // Ajoutez le prix de chaque produit au prix total
//                prixTotal += product.getPrice();
//            }
//        }
//
//        // Ajoutez la liste des produits et le prix total au modèle
//        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
//        model.addAttribute("prixTotal", prixTotal);
//
//
//        return "cartlist"; // Assurez-vous que le nom de la vue est correct
//    }


//        String referer = request.getHeader("Referer");
//        if (referer != null && referer.contains("/telephoneList")) {
//            return "redirect:/telephoneList";
//        } else if (referer != null && referer.contains("/accessoirList")) {
//            return "redirect:/accessoirList";
//        } else {
//            return "error";
//        }


    @GetMapping("/cart/{produitId}")
    public String ajouterAuPanier(@PathVariable Integer produitId, HttpServletRequest request) {
        cartService.ajouteraupanier(produitId);
        String referer = request.getHeader("Referer");
        if (referer != null && referer.contains("/telephone")) {
            return "redirect:/telephone";
        } else if (referer != null && referer.contains("/accessoir")) {
            return "redirect:/accessoir";
        } else {
            return "error";
        }
    }




    @GetMapping("/cart")
    public String afficherPanier(Model model) {
        List<Cart> listeDesProduitsDansLePanier = cartService.getProduitsDansLePanier();
        double prixTotal = listeDesProduitsDansLePanier.stream()
                .mapToDouble(cart -> cart.getProduct().getPrice())
                .sum();
        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
        model.addAttribute("prixTotal", prixTotal);
        return "cartlist"; // Assurez-vous que le nom de la vue est correct
    }











}
