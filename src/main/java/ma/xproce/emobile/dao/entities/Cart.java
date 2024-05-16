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
    private Integer id;
    //ass avec user
    @OneToOne()
    private User user;
    //ass avec cartItem
    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
    private Collection<CartItem>cartItems=new ArrayList<>();
}
