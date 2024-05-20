package ma.xproce.emobile.service.Implementation;

import ma.xproce.emobile.dao.entities.Arrondissement;
import ma.xproce.emobile.dao.repository.ArrondissementRepository;
import ma.xproce.emobile.service.ArrondissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component


public class ArrondissementServiceImp implements ArrondissementService {
    @Autowired
    private ArrondissementRepository arrondissementRepository;
    @Override
    public Page<Arrondissement> getAllArrondissement(String keyword, Pageable pageable) {
        return (Page<Arrondissement>) arrondissementRepository.findByNomContaining(keyword,pageable);
    }

    @Override
    public void createArr(Arrondissement arrondissement) {
        arrondissementRepository.save(arrondissement);
    }

    @Override
    public List<Arrondissement> getAllCategorie2() {
        return arrondissementRepository.findAll();
    }

    @Override
    public Optional<Arrondissement> getArrById(Integer id) {
        return arrondissementRepository.findById(id);
    }

    @Override
    public Arrondissement getArrById2(Integer id) {
        return arrondissementRepository.findById(id).get();
    }

    @Override
    public void updateArr(Arrondissement exArr) {
        arrondissementRepository.save(exArr);
    }

    @Override
    public void deleteById(Integer id) {
        arrondissementRepository.deleteById(id);
    }

    @Override
    public List<Arrondissement> getAllArrondissement2() {
        return arrondissementRepository.findAll();
    }

    @Override
    public Optional<Arrondissement> getArrByIdadr(Integer id) {
        return arrondissementRepository.findById(id);
    }
}
