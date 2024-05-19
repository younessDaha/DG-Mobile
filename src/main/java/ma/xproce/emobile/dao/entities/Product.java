package ma.xproce.emobile.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_produit", discriminatorType = DiscriminatorType.STRING)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String nom;
    private String desc;
    private double price;
    private Integer quantite;
    @Lob
    private String imageFileName;


    //ass avec comm
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Commande>commandes=new ArrayList<>();
    //ass avec cat
    @ManyToOne
    private Categorie categorie;
    //ass avec cartItem
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Cart>carts=new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private Collection<Cart> carts;


}
