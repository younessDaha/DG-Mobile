package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.Accesoir;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface AccesoirService {
    Page<Accesoir> getAllAcc(String keyword, Pageable pageable);

    Accesoir createAcc(Accesoir newAcc);

    List<Accesoir> getAllTele2();
    public Accesoir getAccById(Integer id);

    Accesoir update(Accesoir exAcc);

    void deleteById(Integer id);


}
