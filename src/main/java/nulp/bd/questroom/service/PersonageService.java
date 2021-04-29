package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Personage;
import nulp.bd.questroom.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PersonageService {
    @Autowired
    private PersonageRepository repository;

    public List<Personage> getAll() {
        return repository.findAll();
    }

    public void save(Personage personage) {
        repository.save(personage);
    }

    public Personage get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
