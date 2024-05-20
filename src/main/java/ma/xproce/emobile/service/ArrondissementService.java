package ma.xproce.emobile.service;


import ma.xproce.emobile.dao.entities.Arrondissement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface ArrondissementService {
    Page<Arrondissement> getAllArrondissement(String keyword, Pageable pageable);

    void createArr(Arrondissement arrondissement);

    List<Arrondissement> getAllCategorie2();

    Optional<Arrondissement> getArrById(Integer id);

    Arrondissement getArrById2(Integer id);

    void updateArr(Arrondissement exArr);

    void deleteById(Integer id);

    List<Arrondissement> getAllArrondissement2();

    Optional<Arrondissement> getArrByIdadr(Integer id);
}
