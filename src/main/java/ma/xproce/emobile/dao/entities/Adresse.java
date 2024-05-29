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
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rue;
    private String codePostal;


    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "adresse",fetch = FetchType.LAZY)
    Collection<Commande> commandes = new ArrayList<>();
    @ManyToOne
    private Arrondissement arrondissement;
}
