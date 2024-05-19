package ma.xproce.emobile.service.Implementation;

import jakarta.transaction.Transactional;
import ma.xproce.emobile.dao.entities.Adresse;
import ma.xproce.emobile.dao.entities.Cart;
import ma.xproce.emobile.dao.entities.Commande;
import ma.xproce.emobile.dao.repository.AdresseRepository;
import ma.xproce.emobile.dao.repository.CartRepository;
import ma.xproce.emobile.dao.repository.CommandeRepository;
import ma.xproce.emobile.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class CommandeServiceImp implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    AdresseRepository adresseRepository;
    @Override
    public Optional<Commande> findCommById(Integer id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Page<Commande> getAllTele(Integer id, Pageable pageable) {
        return commandeRepository.findById(id,pageable);
    }

    @Override
    public Commande getCommandeById(Integer commandeId) {
        return commandeRepository.findById(commandeId).orElseGet(() -> {
            Commande newCommande = new Commande();
            // Initialiser la nouvelle commande si nécessaire
            return commandeRepository.save(newCommande);
        });
    }

    @Override
    @Transactional
    public Commande creerCommande(Commande commande) {
        List<Cart> produitsDansLePanier = cartRepository.findAll();
        commande.setProducts(produitsDansLePanier.stream()
                .map(Cart::getProduct)
                .toList());

        double montantTotal = produitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduct().getPrice())
                .sum();
        commande.setPrixTotal(montantTotal);
        commande.setDate(new Date());
        // Récupérer l'adresse associée à la commande
        Adresse adresse = commande.getAdresse();
        // Enregistrer l'adresse si elle n'existe pas déjà
        if (adresse != null && adresse.getId() == null) {
            adresseRepository.save(adresse);
        }

        // Associer l'adresse à la commande
        commande.setAdresse(adresse);

        // Enregistrer la commande
        commandeRepository.save(commande);

        // Vider le panier après avoir passé la commande
        return commande;
    }
}
