package ma.xproce.emobile.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import ma.xproce.emobile.dao.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface CategorieService {
    Page<Categorie> getAllCategorie(String keyword, Pageable pageable);

    Categorie createCategorie(Categorie categorie);

    Categorie updateCategorie(Categorie exCategorie);

    Categorie getCategorieById(Integer id);


    void deleteById(Integer id);

    List<Categorie> getAllCategorie2();

    Categorie findCategorieByNom(String catNom);
}
