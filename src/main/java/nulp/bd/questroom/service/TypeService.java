package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.Type;
import nulp.bd.questroom.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        return repository.findAll();
    }

    public void save(Type type) {
        repository.save(type);
    }

    public Type get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
