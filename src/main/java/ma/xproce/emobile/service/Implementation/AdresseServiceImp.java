package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Adresse;
import ma.xproce.emobile.dao.repository.AdresseRepository;
import ma.xproce.emobile.service.AdresseService;
import ma.xproce.emobile.service.ArrondissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImp implements AdresseService {
    @Autowired
    AdresseRepository adresseRepository;
    @Override
    public Adresse addAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }
}
