package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.dao.entities.Livreur;
import ma.xproce.emobile.service.CategorieService;
import ma.xproce.emobile.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public class LivreurControlleur {
    @Autowired
    private LivreurService livreurService;




    @GetMapping("/livreur")
    public String getCtegorie(Model model,
                              @RequestParam(name = "page", defaultValue = "0" ) int page,
                              @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                              @RequestParam(name = "search", defaultValue = "") String keyword){
        Pageable pageable = PageRequest.of(page, taille);
        Page<Livreur> categories = livreurService.getAllCategorie(keyword,pageable);
        model.addAttribute("cat",categories);
        int[] pages = new int[categories.getTotalPages()];
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);
        return "livreurList";
    }

    @GetMapping("/livreur/new")
    public String addCategorie (Model model){
        Livreur livreur = new Livreur();
        model.addAttribute("cat",livreur);
        return "addlivreur";
    }

    @PostMapping("livreur")
    public  String saveCategorie(Model model,
                                 @RequestParam("nom")String nom,
                                 @RequestParam("num") String num){
        Livreur livreur = new Livreur();
        livreur.setNom(nom);
        livreur.setNum(num);
        livreurService.createCategorie(livreur);
        List<Livreur> livreurs = livreurService.getAllCategorie2();
        model.addAttribute("cat",livreurs);
        return "redirect:/livreur";
    }

    @GetMapping("/livreur/edit/{id}")
    public String editCategorieForm(Model model, @PathVariable Integer id){
        Optional<Livreur> livreur = livreurService.getCategorieById(id);
        model.addAttribute("cat",livreur);
        model.addAttribute("id", id);
        return "editlivreur";

    }
    @PostMapping("/livreur/{id}")
    public String editCategorie(Model model,
                                @PathVariable Integer id,
                                @ModelAttribute("livreur")Livreur livreur){
        Optional<Livreur> exLivreur = livreurService.getCategorieById(id);
        exLivreur.get().setNom(livreur.getNom());
        exLivreur.get().setNum(livreur.getNum());
        livreurService.updateCategorie(exLivreur);
        return "redirect:/livreur";
    }

    @GetMapping("/livreur/{id}")
    public String deleteUser(@PathVariable Integer id){
        livreurService.deleteById(id);
        return "redirect:/livreur";
    }


}
