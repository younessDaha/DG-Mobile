package ma.xproce.emobile.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("telephone")
public class Telephone extends Product {
    private String marque;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Cart> carts=new ArrayList<>();
}
