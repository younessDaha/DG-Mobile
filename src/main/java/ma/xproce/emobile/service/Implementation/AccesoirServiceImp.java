package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Accesoir;
import ma.xproce.emobile.dao.entities.Telephone;
import ma.xproce.emobile.dao.repository.AccesoirRepository;
import ma.xproce.emobile.service.AccesoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccesoirServiceImp implements AccesoirService {
    @Autowired
    AccesoirRepository accesoirRepository;
    @Override
    public Page<Accesoir> getAllAcc(String keyword, Pageable pageable) {
        return accesoirRepository.findByNomContaining(keyword,pageable);
    }

    @Override
    public Accesoir createAcc(Accesoir newAcc) {
        return accesoirRepository.save(newAcc);
    }

    @Override
    public List<Accesoir> getAllTele2() {
        return accesoirRepository.findAll();
    }

    @Override
    public Accesoir getAccById(Integer id) {
        Optional<Accesoir> accesoirOptional = accesoirRepository.findById(id);
        return accesoirOptional.orElse(null);
    }

    @Override
    public Accesoir update(Accesoir exAcc) {
        return accesoirRepository.save(exAcc);
    }

    @Override
    public void deleteById(Integer id) {
        accesoirRepository.deleteById(id);
    }
}
