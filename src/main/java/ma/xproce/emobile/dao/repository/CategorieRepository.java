package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.dao.entities.Telephone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
    Categorie findByNom(String catNom);

    Page<Categorie> findByNomContaining(String keyword, Pageable pageable);


}
