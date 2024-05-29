package ma.xproce.emobile.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String mdps;
//    private String adress;
    private String email;

    @ManyToOne
    private Role role;

    //ass avec cart
    @OneToOne(mappedBy = "user")
    private Cart cart;
    //ass avec commande
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Collection<Commande>commandes=new ArrayList<>();

    @Override
    public String toString() {
        return "User{id=" + id + ", nom=" + nom + "}";
    }
}
