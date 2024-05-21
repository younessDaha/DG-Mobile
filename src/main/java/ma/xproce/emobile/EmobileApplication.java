package ma.xproce.emobile;

import ma.xproce.emobile.dao.entities.*;
import ma.xproce.emobile.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

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
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ArrondissementRepository arrondissementRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(EmobileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user=new User();
////        user.setAdress("aaaaa");
//        user.setMdps("12345");
////        user.setRole("user");
//        user.setNom("younes");
////        user.setEmail("aaaaaaa");
//        userRepository.save(user);

        Categorie categorie = new Categorie();
        categorie.setNom("telephone");
        categorieRepository.save(categorie);
        Categorie categorie1 = new Categorie();
        categorie1.setNom("watch");
        categorieRepository.save(categorie1);

        Commande commande = new Commande();
        commande.setDate(new Date(2022,11,23));
//        commande.setUser(user);
        commande.setPrixTotal(22.22);
        commandeRepository.save(commande);

        Telephone telephone = new Telephone();
        telephone.setNom("iphone 11");
        telephone.setDesc("bon plan");
        telephone.setPrice(2500.00);
        telephone.setCategorie(categorie);
        telephone.setImageFileName("i15.jpg");
        telephone.setMarque("appel");
        telephone.setQuantite(3);
        telephoneRepository.save(telephone);

        Telephone telephone1 = new Telephone();
        telephone1.setNom("iphone 11");
        telephone1.setDesc("bon plan");
        telephone1.setPrice(2500.00);
        telephone1.setCategorie(categorie);
        telephone1.setImageFileName("i15.jpg");
        telephone1.setMarque("appel");
        telephone1.setQuantite(3);
        telephoneRepository.save(telephone1);

        Telephone telephone2 = new Telephone();
        telephone2.setNom("iphone 11");
        telephone2.setDesc("bon plan");
        telephone2.setPrice(2500.00);
        telephone2.setCategorie(categorie);
        telephone2.setImageFileName("i15.jpg");
        telephone2.setMarque("appel");
        telephone2.setQuantite(3);
        telephoneRepository.save(telephone2);
Telephone telephone3 = new Telephone();
        telephone3.setNom("iphone 11");
        telephone3.setDesc("bon plan");
        telephone3.setPrice(2500.00);
        telephone3.setCategorie(categorie);
        telephone3.setImageFileName("i15.jpg");
        telephone3.setMarque("appel");
        telephone3.setQuantite(3);
        telephoneRepository.save(telephone3);

        Accesoir accesoir = new Accesoir();
        accesoir.setNom("appel watch");
        accesoir.setDesc("bon ");
        accesoir.setPrice(2500.00);
        accesoir.setType("smart watch");
        accesoir.setCategorie(categorie1);
        accesoir.setImageFileName("w.jpg");
        accesoir.setQuantite(3);
        accesoirRepository.save(accesoir);

        Accesoir accesoir1 = new Accesoir();
        accesoir1.setNom("appel watch");
        accesoir1.setDesc("bon ");
        accesoir1.setPrice(2500.00);
        accesoir1.setType("smart watch");
        accesoir1.setCategorie(categorie1);
        accesoir1.setImageFileName("w.jpg");
        accesoir1.setQuantite(3);
        accesoirRepository.save(accesoir1);
        Accesoir accesoir2 = new Accesoir();
        accesoir2.setNom("appel watch");
        accesoir2.setDesc("bon ");
        accesoir2.setPrice(2500.00);
        accesoir2.setType("smart watch");
        accesoir2.setCategorie(categorie1);
        accesoir2.setImageFileName("w.jpg");
        accesoir2.setQuantite(3);
        accesoirRepository.save(accesoir2);
        Accesoir accesoir3 = new Accesoir();
        accesoir3.setNom("appel watch");
        accesoir3.setDesc("bon ");
        accesoir3.setPrice(2500.00);
        accesoir3.setType("smart watch");
        accesoir3.setCategorie(categorie1);
        accesoir3.setImageFileName("w.jpg");
        accesoir3.setQuantite(3);
        accesoirRepository.save(accesoir3);
//
        Role roleUser = new Role();
        roleUser.setNom("user");
        roleRepository.save(roleUser);
//        Role roleAdmin = new Role();
//        roleAdmin.setNom("admin");
//        roleRepository.save(roleAdmin);

//
//
//        user.setRole(roleAdmin);
//        userRepository.save(user);
//
        User user=new User();
//        user.setAdress("aaaaa");
        user.setMdps("12345");
//        user.setRole("user");
        user.setNom("younes");
        user.setEmail("aaaaaaa");
        Role roleAdmin = new Role();
        roleAdmin.setNom("admin");
        roleRepository.save(roleAdmin);
user.setRole(roleAdmin);
        userRepository.save(user);


    Arrondissement arrondissement = new Arrondissement();
    arrondissement.setNom("fida mers sultan");
    arrondissementRepository.save(arrondissement);
Arrondissement arrondissement1 = new Arrondissement();
    arrondissement1.setNom("ain chock");
    arrondissementRepository.save(arrondissement1);
Arrondissement arrondissement2 = new Arrondissement();
    arrondissement2.setNom("sbite");
    arrondissementRepository.save(arrondissement2);
Arrondissement arrondissement3 = new Arrondissement();
    arrondissement3.setNom("oulfa");
    arrondissementRepository.save(arrondissement3);
        System.out.println("its work");

    }
}
