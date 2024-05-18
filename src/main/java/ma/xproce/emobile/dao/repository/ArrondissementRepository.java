package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Arrondissement;
import ma.xproce.emobile.dao.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrondissementRepository extends JpaRepository<Arrondissement,Integer> {
    Page<Arrondissement> findByNomContaining(String keyword, Pageable pageable);
}
