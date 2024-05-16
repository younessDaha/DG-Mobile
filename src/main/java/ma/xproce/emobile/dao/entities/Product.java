package ma.xproce.emobile.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Product {
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
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Collection<CartItem>cartItems=new ArrayList<>();


}
