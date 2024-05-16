package ma.xproce.emobile.service;

import ma.xproce.emobile.dao.entities.Telephone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TelephoneService {
    Page<Telephone> getAllTele(String keyword, Pageable pageable);

    Telephone createTele(Telephone newtele);

    List<Telephone> getAllTele2();


    Telephone getUserById(Integer id);

    Telephone updateUser(Telephone exTele);

    void deleteById(Integer id);

}
