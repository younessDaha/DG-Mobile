package ma.xproce.emobile.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nom;
    private String num;

    @OneToOne
    private Arrondissement arrondissement;

    @Override
    public String toString() {
        return  nom;
    }
}
