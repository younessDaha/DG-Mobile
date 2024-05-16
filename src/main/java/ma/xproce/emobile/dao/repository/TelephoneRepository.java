package ma.xproce.emobile.dao.repository;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Telephone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone,Integer> {
//    Page<Telephone> findByModeleContaining(String keyword, Pageable pageable);

    Page<Telephone> findByNomContaining(String keyword, Pageable pageable);
}
