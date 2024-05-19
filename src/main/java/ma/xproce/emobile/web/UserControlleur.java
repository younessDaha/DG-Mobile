package ma.xproce.emobile.web;

import ma.xproce.emobile.dao.entities.Role;
import ma.xproce.emobile.dao.entities.User;
import ma.xproce.emobile.service.RoleService;
import ma.xproce.emobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserControlleur {
    @Autowired
    private UserService userService;
@Autowired
    private RoleService roleService;



    @GetMapping("/user")
    public String ListUser(Model model,
                           @RequestParam(name = "page", defaultValue = "0" ) int page,
                           @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                           @RequestParam(name = "search", defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, taille);
        Page<User> users = userService.getAllUser(keyword,pageable);
        model.addAttribute("user", users);
        int[] pages = new int[users.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);
        return "userList";
    }

    @GetMapping("/user/new")
    public String creatUser(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "addUser";
    }


    @PostMapping("/user")
    public String saveUser(Model model,
                           @RequestParam("nom") String nom,
//                           @RequestParam("adress") String adress,
                           @RequestParam("email") String email,
                           @RequestParam("mdps") String mdps
    ) {
        System.out.println("Nom: " + nom);
//        System.out.println("Adresse: " + adress);
        System.out.println("Email: " + email);
        System.out.println("mdps: " + mdps);
        // Récupérer le rôle "user" depuis la base de données
        Role userRole = roleService.findRoleByNom("user");


        User newUser = new User();


        // Sauvegardez votre nouvel utilisateur
        newUser.setNom(nom);
//        newUser.setAdress(adress);
        newUser.setEmail(email);
        newUser.setMdps(mdps);
        // Assigner le rôle "user" à l'utilisateur

        newUser.setRole(userRole);
        userService.createUser(newUser);

        List<User> users = userService.getAllUser2();
        model.addAttribute("user", users);
        return "redirect:/user";
    }

    @GetMapping("/user/edit/{id}")
    public String edditUserForm(Model model, @PathVariable Integer id){
        model.addAttribute("user",userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/user/{id}")
    public String edditUser(Model model,
                            @PathVariable Integer id,
                            @ModelAttribute("User")User user){
        User exUser = userService.getUserById(id);
        exUser.setId(id);
//        exUser.setAdress(user.getAdress());
        exUser.setNom(user.getNom());
        exUser.setEmail(user.getEmail());
        userService.updateUser(exUser);

        return "redirect:/user";
    }
    @GetMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteById(id);
        return "redirect:/user";
    }
}

