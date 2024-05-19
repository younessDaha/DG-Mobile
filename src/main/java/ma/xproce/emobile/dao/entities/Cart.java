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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private Integer quantity;
    //ass avec user
    @OneToOne()
    private User user;
    //ass avec product
//    @ManyToMany(mappedBy = "carts",fetch = FetchType.EAGER)
//    private Collection<Product>products=new ArrayList<>();
    @ManyToOne
    private Product product;

//    @ManyToMany(mappedBy = "carts",fetch = FetchType.EAGER)
//    private Collection<Telephone>telephones=new ArrayList<>();

    public Cart(Product product) {
        this.product=product;
    }
}
