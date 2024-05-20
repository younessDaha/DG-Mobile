package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Livreur;
import ma.xproce.emobile.dao.repository.LivreurRepository;
import ma.xproce.emobile.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component


public class LivreurServiceImp implements LivreurService {
    @Autowired
    LivreurRepository livreurRepository;
    @Override
    public Page<Livreur> getAllCategorie(String keyword, Pageable pageable) {
        return livreurRepository.findByNomContaining(keyword,pageable);
    }

    @Override
    public void createCategorie(Livreur livreur) {
        livreurRepository.save(livreur);
    }

    @Override
    public List<Livreur> getAllCategorie2() {
        return livreurRepository.findAll();
    }

    @Override
    public Optional<Livreur> getCategorieById(Integer id) {
        return livreurRepository.findById(id);
    }

    @Override
    public void updateCategorie(Optional<Livreur> exLivreur) {
        livreurRepository.save(exLivreur.get());
    }


    @Override
    public void deleteById(Integer id) {
        livreurRepository.deleteById(id);
    }
}
