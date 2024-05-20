package ma.xproce.emobile.service;


import ma.xproce.emobile.dao.entities.Livreur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface LivreurService {
    Page<Livreur> getAllCategorie(String keyword, Pageable pageable);

    void createCategorie(Livreur livreur);

    List<Livreur> getAllCategorie2();

    Optional<Livreur> getCategorieById(Integer id);

    void updateCategorie(Optional<Livreur> exLivreur);

    void deleteById(Integer id);
}
