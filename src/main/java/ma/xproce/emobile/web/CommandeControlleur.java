package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.*;
import ma.xproce.emobile.dao.repository.CommandeRepository;
import ma.xproce.emobile.service.AdresseService;
import ma.xproce.emobile.service.ArrondissementService;
import ma.xproce.emobile.service.CartService;
import ma.xproce.emobile.service.CommandeService;
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
public class CommandeControlleur {
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CartService cartService;
    @Autowired
    private AdresseService adresseService;
    @Autowired
    private ArrondissementService arrondissementService;
    @Autowired
    private CommandeRepository commandeRepository;


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







    @GetMapping("/afficher-commande")
    public String afficherCommande(Model model) {
        List<Cart> listeDesProduitsDansLePanier = cartService.getProduitsDansLePanier();
        double prixTotal = listeDesProduitsDansLePanier.stream()
                .mapToDouble(cart -> cart.getProduct().getPrice())
                .sum();
        Commande commande = new Commande();
        commande.setId(1);
        commandeRepository.save(commande);
        List<Arrondissement> arrondissementList = arrondissementService.getAllArrondissement2();
        model.addAttribute("arrondissements", arrondissementList);
        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
        model.addAttribute("prixTotal", prixTotal);
        model.addAttribute("commande", commande);
        model.addAttribute("adresse", new Adresse());
        return "commande"; // Assurez-vous que le nom de la vue est correct
    }


    @PostMapping("/ajouter-adresse")
    public String ajouterAdresse(Model model,
                                 @RequestParam(name = "rue") String rue,
                                 @RequestParam(name = "arrondissements") Arrondissement arrondissements,
//                                 @RequestParam(name = "ville") String ville,
                                 @RequestParam(name = "codepostal") String codepostal

//                                 @RequestParam(name = "pays") String pays,
                                 //@RequestParam(name = "id") Integer
                                 ) {
        // Créer une nouvelle adresse
        Adresse adresse = new Adresse();
        adresse.setRue(rue);
//        adresse.setVille(ville);
        adresse.setCodePostal(codepostal);
        adresse.setArrondissement(arrondissements);
//        adresse.setPays(pays);

        // Récupérer la commande associée
        Commande commande = new Commande();
        commandeService.creerCommande(commande);
        commande = commandeService.getCommandeById(1);

        // Lier l'adresse à la commande
        commande.setAdresse(adresse);

        // Enregistrer l'adresse
        adresseService.addAdresse(adresse);

        List<Arrondissement> arrondissementList = arrondissementService.getAllArrondissement2();
        model.addAttribute("arrondissements", arrondissementList);


        // Passer la commande mise à jour à la vue de confirmation
        model.addAttribute("commande", commande);

        return "redirect:/confirmation?commandeId=" +commande.getId(); // Rediriger vers la page de confirmation
    }


    @GetMapping("/passer-commande")
    public String afficherFormulaire(Model model) {
        model.addAttribute("commande", new Commande());
        model.addAttribute("adresse", new Adresse());
        return "commande"; // Assurez-vous que ce nom de vue correspond à votre fichier HTML
    }


    @PostMapping("/passer-commande")
    public String passerCommande(@ModelAttribute Commande commande, @ModelAttribute Adresse adresse) {
        commande.setAdresse(adresse); // Associez l'adresse à la commande
        Commande commandeEnregistree = commandeService.creerCommande(commande); // Enregistrez la commande et récupérez-la
        return "redirect:/confirmation?commandeId=" + commandeEnregistree.getId();
    }

    @GetMapping("/confirmation")
    public String afficherConfirmation(@RequestParam("commandeId") Integer commandeId, Model model) {
        Commande commande = commandeService.getCommandeById(commandeId);
        Optional<Arrondissement> arrondissement = arrondissementService.getArrByIdadr(commande.getAdresse().getId());
        model.addAttribute("commande", commande);

        cartService.viderPanier();

        return "confirmation";
    }






}
//    @GetMapping("/comm")
//    public String ListComm(Model model,
//                           @RequestParam(name = "page", defaultValue = "0" ) int page,
//                           @RequestParam(name = "taille", defaultValue = "6" ) int taille,
//                           @RequestParam(name = "search", defaultValue = "") Integer id) {
//        Pageable pageable = PageRequest.of(page, taille);
//
//        Page<Commande> commandes = commandeService.getAllTele(id,pageable);
//        model.addAttribute("comm", commandes);
//        int[] pages = new int[commandes.getTotalPages()];
//        for (int i = 0; i < pages.length; i++) {
//            pages[i] = i;
//        }
//        model.addAttribute("pages" , pages);
//        model.addAttribute("currentpages",page);
//
//        return "commList";
//    }
//
//    @GetMapping("/Comm/{id}")
//    public String getCommById (Model model, @PathVariable("id")Integer id){
//        Optional<Commande> commande=commandeService.findCommById(id);
//        model.addAttribute("comm",commande);
//        return "commList";
//    }