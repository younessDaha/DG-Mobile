package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Commande;
import ma.xproce.emobile.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Controller
public class CommandeControlleur {
    @Autowired
    CommandeService commandeService;




    @GetMapping("/comm")
    public String ListComm(Model model,
                           @RequestParam(name = "page", defaultValue = "0" ) int page,
                           @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                           @RequestParam(name = "search", defaultValue = "") Integer id) {
        Pageable pageable = PageRequest.of(page, taille);

        Page<Commande> commandes = commandeService.getAllTele(id,pageable);
        model.addAttribute("comm", commandes);
        int[] pages = new int[commandes.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);

        return "commList";
    }

    @GetMapping("/Comm/{id}")
    public String getCommById (Model model, @PathVariable("id")Integer id){
        Optional<Commande> commande=commandeService.findCommById(id);
        model.addAttribute("comm",commande);
        return "commList";
    }
}
