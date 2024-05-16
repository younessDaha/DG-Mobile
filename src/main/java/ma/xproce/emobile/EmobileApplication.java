package ma.xproce.emobile;

import ma.xproce.emobile.dao.entities.*;
import ma.xproce.emobile.dao.repository.*;
import ma.xproce.emobile.service.Implementation.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EmobileApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private TelephoneRepository telephoneRepository;
    @Autowired
    private AccesoirRepository accesoirRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(EmobileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user=new User();
        user.setAdress("aaaaa");
        user.setNom("younes");
        user.setEmail("aaaaaaa");
        userRepository.save(user);

        Categorie categorie = new Categorie();
        categorie.setNom("telephone");
        categorieRepository.save(categorie);
        Categorie categorie1 = new Categorie();
        categorie1.setNom("watch");
        categorieRepository.save(categorie1);

        Commande commande = new Commande();
        commande.setDate(new Date(2022,11,23));
        commande.setUser(user);
        commande.setPrixTotal(22.22);
        commandeRepository.save(commande);

        Telephone telephone = new Telephone();
        telephone.setNom("iphone 11");
        telephone.setDesc("bon plan");
        telephone.setPrice(2500.00);
        telephone.setCategorie(categorie);
        telephone.setImageFileName("MasterPiece.png");
        telephone.setMarque("appel");
        telephone.setQuantite(3);
        telephoneRepository.save(telephone);

        Accesoir accesoir = new Accesoir();
        accesoir.setNom("appel watch");
        accesoir.setDesc("bon ");
        accesoir.setPrice(2500.00);
        accesoir.setType("smart watch");
        accesoir.setCategorie(categorie1);
        accesoir.setQuantite(3);
        accesoirRepository.save(accesoir);




    }
}