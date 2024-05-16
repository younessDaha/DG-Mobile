package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface CommandeService {
    Optional<Commande> findCommById(Integer id);

    Page<Commande> getAllTele(Integer keyword, Pageable pageable);
}
