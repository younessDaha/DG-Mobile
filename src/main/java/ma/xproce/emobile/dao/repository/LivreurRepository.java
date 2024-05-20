package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.dao.entities.Livreur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreurRepository extends JpaRepository<Livreur,Integer> {
    Page<Livreur> findByNomContaining(String keyword, Pageable pageable);
}
