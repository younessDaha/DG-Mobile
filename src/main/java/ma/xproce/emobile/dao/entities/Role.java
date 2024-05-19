package ma.xproce.emobile.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Collection<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return "Role{id=" + id + ", nom=" + nom + "}";
    }
}
