package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Categorie;
import ma.xproce.emobile.dao.entities.User;
import ma.xproce.emobile.dao.repository.CategorieRepository;
import ma.xproce.emobile.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategorieServiceImp implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public Page<Categorie> getAllCategorie(String keyword, Pageable pageable) {
        return (Page<Categorie>) categorieRepository.findByNomContaining(keyword,pageable);
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie exCategorie) {
        return categorieRepository.save(exCategorie);
    }

    @Override
    public Categorie getCategorieById(Integer id) {
        Optional<Categorie> userOptional = categorieRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<Categorie> getAllCategorie2() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie findCategorieByNom(String catNom) {
        return categorieRepository.findByNom(catNom);
    }


}
