package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.dao.entities.Product;
import ma.xproce.emobile.dao.entities.Telephone;
import ma.xproce.emobile.service.CategorieService;
import ma.xproce.emobile.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TelephoneControlleur {
    @Autowired
    private TelephoneService telephoneService;
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/telephone")
    public String ListUser(Model model,
                           @RequestParam(name = "page", defaultValue = "0" ) int page,
                           @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                           @RequestParam(name = "search", defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, taille);

        Page<Telephone> telephones = telephoneService.getAllTele(keyword,pageable);
        model.addAttribute("tele", telephones);
        int[] pages = new int[telephones.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);

        return "telephoneList";
    }

    @GetMapping("/telephone/new")
    public String creatUser(Model model){
        Product telephone=new Telephone();
        List<Categorie>categories=categorieService.getAllCategorie2();
        model.addAttribute("categories",categories);
        model.addAttribute("telephones",telephone);
        return "addTelephone";
    }
    @PostMapping("/telephone")
    public String saveUser(Model model,
                           @RequestParam("nom") String nom,
                           @RequestParam("marque") String marque,
                           @RequestParam("imageFileName") String imageFileName,
                           @RequestParam("prix") double prix,
                           @RequestParam("desc") String desc,
                           @RequestParam("categorie") Categorie categorie,
                           @RequestParam("quantite") int quantite) {
        System.out.println("Nom: " + nom);
        System.out.println("marque: " + marque);
        System.out.println("prix: " + prix);
        System.out.println("imageFileName: " + imageFileName);
        System.out.println("desc: " + desc);
        System.out.println("Categorie: " + categorie);
        System.out.println("quantite: " + quantite);



        // Sauvegardez votre nouvel utilisateur
        Telephone newtele = new Telephone();
        newtele.setNom(nom);
        newtele.setMarque(marque);
        newtele.setImageFileName(imageFileName);
        newtele.setPrice(prix);
        newtele.setDesc(desc);
        newtele.setCategorie(categorie);
        newtele.setQuantite(quantite);
        telephoneService.createTele(newtele);



        List<Telephone> telephones = telephoneService.getAllTele2();
        model.addAttribute("telephones", telephones);
        return "redirect:/telephone";
    }


    @GetMapping("/telephone/edit/{id}")
    public String edditTeleForm(Model model, @PathVariable Integer id){
        model.addAttribute("telephone",telephoneService.getUserById(id));
        List<Categorie>categories=categorieService.getAllCategorie2();
        model.addAttribute("categories", categories);
        return "editTelephone";
    }

    @PostMapping("/telephone/{id}")
    public String edditTele(Model model,
                            @PathVariable Integer id,
                            @ModelAttribute("Telephones") Telephone telephone){
        Telephone exTele = telephoneService.getUserById(id);
        exTele.setId(id);
        exTele.setQuantite(telephone.getQuantite());
        exTele.setCategorie(telephone.getCategorie());
        exTele.setMarque(telephone.getMarque());
        exTele.setDesc(telephone.getDesc());
        exTele.setPrice(telephone.getPrice());
        telephoneService.updateUser(exTele);

        return "redirect:/telephone";
    }
    @GetMapping("/telephone/{id}")
    public String deleteTele(@PathVariable Integer id){
        telephoneService.deleteById(id);
        return "redirect:/telephone";
    }


}
