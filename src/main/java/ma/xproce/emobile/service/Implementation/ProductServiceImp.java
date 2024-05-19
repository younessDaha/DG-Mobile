package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Product;
import ma.xproce.emobile.dao.repository.ProductRepository;
import ma.xproce.emobile.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
//    @Override
//    public Product getProductById(Integer produitId) {
//        return productRepository.findById(produitId);
//    }
}
