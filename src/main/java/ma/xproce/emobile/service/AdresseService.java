package ma.xproce.emobile.service;


import ma.xproce.emobile.dao.entities.Adresse;
import org.springframework.stereotype.Service;

@Service
public interface AdresseService {
    Adresse addAdresse(Adresse adresse);
}
