package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Arrondissement;
import ma.xproce.emobile.service.ArrondissementService;
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

public class ArrondissementControlleur {
    @Autowired
    private ArrondissementService arrondissementService;




    @GetMapping("/arrlist")
    public String getArr(Model model,
                              @RequestParam(name = "page", defaultValue = "0" ) int page,
                              @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                              @RequestParam(name = "search", defaultValue = "") String keyword){
        Pageable pageable = PageRequest.of(page, taille);
        Page<Arrondissement> arrondissement = arrondissementService.getAllArrondissement(keyword,pageable);
        model.addAttribute("cat",arrondissement);
        int[] pages = new int[arrondissement.getTotalPages()];
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);
        return "arrlist";
    }

    @GetMapping("/arr/new")
    public String addArr (Model model){
        Arrondissement arrondissement = new Arrondissement();
        model.addAttribute("arr",arrondissement);
        return "addArr";
    }

    @PostMapping("arr")
    public  String saveArr(Model model,
                                 @RequestParam("nom")String nom){
        Arrondissement arrondissement = new Arrondissement();
        arrondissement.setNom(nom);
        arrondissementService.createArr(arrondissement);
        List<Arrondissement> arrondissements = arrondissementService.getAllCategorie2();
        model.addAttribute("arr",arrondissements);
        return "redirect:/arrlist";
    }


    @GetMapping("/arr/edit/{id}")
    public String editarrForm(Model model, @PathVariable Integer id){
        Optional<Arrondissement> arrondissement = arrondissementService.getArrById(id);
        model.addAttribute("arr",arrondissement.get());
        model.addAttribute("id", id);
        return "editarr";

    }

    @PostMapping("/arr/{id}")
    public String editArr(Model model,
                                @PathVariable Integer id,
                                @ModelAttribute("arrondissement")Arrondissement arrondissement){
        Arrondissement exArr = arrondissementService.getArrById2(id);
        exArr.setNom(arrondissement.getNom());
        arrondissementService.updateArr(exArr);
        return "redirect:/arrlist";
    }

    @GetMapping("/arr/{id}")
    public String deleteUser(@PathVariable Integer id){
        arrondissementService.deleteById(id);
        return "redirect:/arrlist";
    }

}
