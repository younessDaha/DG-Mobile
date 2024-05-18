package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Cart;
import ma.xproce.emobile.dao.entities.Product;
import ma.xproce.emobile.dao.entities.Telephone;
import ma.xproce.emobile.service.CartService;
import ma.xproce.emobile.service.CommandeService;
import ma.xproce.emobile.service.ProductService;
import ma.xproce.emobile.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CartControlleur {
    @Autowired
    private CartService cartService;
    @Autowired
    private TelephoneService telephoneService;

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



    @GetMapping("/cart")
    public String afficherCart(Model model){
        Cart cart = cartService.findAll();
        model.addAttribute("cart",cart);
        return "cart";
    }

    @PostMapping("/cart/{id}")
    public String ajouterProToCar(@PathVariable Integer id){
        cartService.addTelToCart(id);
        return "/redirect:telephoneList";
    }

}
