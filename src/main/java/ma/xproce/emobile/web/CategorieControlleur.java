package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategorieControlleur {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categorie")
    public String getCtegorie(Model model,
                              @RequestParam(name = "page", defaultValue = "0" ) int page,
                              @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                              @RequestParam(name = "search", defaultValue = "") String keyword){
        Pageable pageable = PageRequest.of(page, taille);
        Page<Categorie> categories = categorieService.getAllCategorie(keyword,pageable);
        model.addAttribute("cat",categories);
        int[] pages = new int[categories.getTotalPages()];
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);
        return "categorieList";
    }

    @GetMapping("/categorie/new")
    public String addCategorie (Model model){
        Categorie categorie = new Categorie();
        model.addAttribute("cat",categorie);
        return "addCategorie";
    }

    @PostMapping("categorie")
    public  String saveCategorie(Model model,
                                 @RequestParam("nom")String nom){
        Categorie categorie = new Categorie();
        categorie.setNom(nom);
        categorieService.createCategorie(categorie);
        List<Categorie> categories = categorieService.getAllCategorie2();
        model.addAttribute("cat",categories);
        return "redirect:/categorie";
    }

    @GetMapping("/categorie/edit/{id}")
    public String editCategorieForm(Model model, @PathVariable Integer id){
        Categorie categories = categorieService.getCategorieById(id);
        model.addAttribute("cat",categories);
        model.addAttribute("id", id);
        return "editCategorie";

    }
    @PostMapping("/categorie/{id}")
    public String editCategorie(Model model,
                                @PathVariable Integer id,
                                @ModelAttribute("categorie")Categorie categorie){
        Categorie exCategorie = categorieService.getCategorieById(id);
        exCategorie.setNom(categorie.getNom());
        categorieService.updateCategorie(exCategorie);
        return "redirect:/categorie";
    }

    @GetMapping("/categorie/{id}")
    public String deleteUser(@PathVariable Integer id){
        categorieService.deleteById(id);
        return "redirect:/categorie";
    }

}
