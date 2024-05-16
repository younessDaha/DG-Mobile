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
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    //ass avec prod
    @OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER)
    private Collection<Product>products=new ArrayList<>();

    @Override
    public String toString() {
        return  nom
                ;
    }
}
