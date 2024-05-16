package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Telephone;
import ma.xproce.emobile.dao.entities.User;
import ma.xproce.emobile.dao.repository.TelephoneRepository;
import ma.xproce.emobile.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TelephoneServiceImp implements TelephoneService {
    @Autowired
    TelephoneRepository telephoneRepository;
    @Override
    public Page<Telephone> getAllTele(String keyword, Pageable pageable) {
        return telephoneRepository.findByNomContaining(keyword,pageable);
    }

    @Override
    public Telephone createTele(Telephone newtele) {
        return telephoneRepository.save(newtele);
    }

    @Override
    public List<Telephone> getAllTele2() {
        return telephoneRepository.findAll();
    }

    @Override
    public Telephone getUserById(Integer id) {
        Optional<Telephone> telephoneOptional = telephoneRepository.findById(id);
        return telephoneOptional.orElse(null);
    }

    @Override
    public Telephone updateUser(Telephone exTele) {
        return telephoneRepository.save(exTele);
    }

    @Override
    public void deleteById(Integer id) {
        telephoneRepository.deleteById(id);
    }


}
