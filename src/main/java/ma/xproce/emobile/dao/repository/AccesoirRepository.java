package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Accesoir;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccesoirRepository extends JpaRepository<Accesoir,Integer> {
    Page<Accesoir> findByNomContaining(String keyword, Pageable pageable);
}
