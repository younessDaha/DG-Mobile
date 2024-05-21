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
public class Arrondissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;

    public Arrondissement(String nom) {
        this.nom = nom;
    }

//    @OneToMany(mappedBy = "arrondissement",fetch = FetchType.EAGER)
//    Collection<Commande>commandes = new ArrayList<>();

    @OneToOne(mappedBy = "arrondissement")
    private Livreur livreur;

    @OneToMany(mappedBy = "arrondissement",fetch = FetchType.EAGER)
    Collection<Adresse>adresses=new ArrayList<>();

    @Override
    public String toString() {
        return  nom
                ;
    }


}
