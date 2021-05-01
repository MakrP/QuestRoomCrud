package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository repository;

    public List<Institution> getAll() {
        return repository.findAll();
    }

    public void save(Institution institution) {
        repository.save(institution);
    }

    public Institution get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<String> getAllCities() {
        return repository.getCities();
    }
    public List<Institution> getAllByCity(String city) {
        return repository.getAllByCity(city);
    }


}
