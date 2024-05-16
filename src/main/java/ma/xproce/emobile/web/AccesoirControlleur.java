package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.service.AccesoirService;
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
public class AccesoirControlleur {
    @Autowired
    private AccesoirService accesoirService;
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/accessoir")
    public String ListUser(Model model,
                           @RequestParam(name = "page", defaultValue = "0" ) int page,
                           @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                           @RequestParam(name = "search", defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, taille);
        Page<Accesoir> accesoirs = accesoirService.getAllAcc(keyword,pageable);
        model.addAttribute("acc", accesoirs);
        int[] pages = new int[accesoirs.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);

        return "accessoirList";
    }

    @GetMapping("/accessoir/new")
    public String creatUser(Model model){
        Accesoir accesoir=new Accesoir();
        List<Categorie> categories=categorieService.getAllCategorie2();
        model.addAttribute("categories",categories);
        model.addAttribute("acc",accesoir);
        return "addAcc";
    }
    @PostMapping("/accessoir")
    public String saveUser(Model model,
                           @RequestParam("nom") String nom,
                           @RequestParam("type") String type,
                           @RequestParam("prix") double prix,
                           @RequestParam("desc") String desc,
                           @RequestParam("categorie") Categorie categorie,
                           @RequestParam("quantite") int quantite) {
        System.out.println("Nom: " + nom);
        System.out.println("type: " + type);
        System.out.println("prix: " + prix);
        System.out.println("desc: " + desc);
        System.out.println("Categorie: " + categorie);
        System.out.println("quantite: " + quantite);




        // Sauvegardez votre nouvel utilisateur
        Accesoir newAcc = new Accesoir();
        newAcc.setNom(nom);
        newAcc.setType(type);
        newAcc.setPrice(prix);
        newAcc.setDesc(desc);
        newAcc.setCategorie(categorie);
        newAcc.setQuantite(quantite);
        accesoirService.createAcc(newAcc);

        List<Accesoir> accesoirs = accesoirService.getAllTele2();
        model.addAttribute("acc", accesoirs);
        return "redirect:/accessoir";
    }


    @GetMapping("/accessoir/edit/{id}")
    public String edditTeleForm(Model model, @PathVariable Integer id){
        model.addAttribute("accessoir",accesoirService.getAccById(id));
        List<Categorie>categories=categorieService.getAllCategorie2();
        model.addAttribute("categories", categories);
        return "editAcc";
    }

    @PostMapping("/accessoir/{id}")
    public String edditTele(Model model,
                            @PathVariable Integer id,
                            @ModelAttribute("accesoir") Accesoir accesoir){
        Accesoir exAcc = accesoirService.getAccById(id);
        exAcc.setId(id);
        exAcc.setQuantite(accesoir.getQuantite());
        exAcc.setCategorie(accesoir.getCategorie());
        exAcc.setType(accesoir.getType());
        exAcc.setDesc(accesoir.getDesc());
        exAcc.setPrice(accesoir.getPrice());
        accesoirService.update(exAcc);

        return "redirect:/accessoir";
    }
    @GetMapping("/accessoir/{id}")
    public String deleteTele(@PathVariable Integer id){
        accesoirService.deleteById(id);
        return "redirect:/accessoir";
    }

}
