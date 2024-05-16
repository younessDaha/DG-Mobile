package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Commande;
import ma.xproce.emobile.dao.repository.CommandeRepository;
import ma.xproce.emobile.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommandeServiceImp implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Override
    public Optional<Commande> findCommById(Integer id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Page<Commande> getAllTele(Integer id, Pageable pageable) {
        return commandeRepository.findById(id,pageable);
    }
}
