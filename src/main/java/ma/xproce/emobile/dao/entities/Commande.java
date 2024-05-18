package ma.xproce.emobile.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private double prixTotal;

    //ass avec user
    @ManyToOne
    private User user;
    //ass avec prod
    @ManyToMany(mappedBy = "commandes",fetch = FetchType.EAGER)
    private Collection<Product>products=new ArrayList<>();

    @ManyToOne
    private Arrondissement arrondissement;
}
