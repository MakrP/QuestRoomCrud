package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.Employee;
import nulp.bd.questroom.entity.FindOutMethod;
import nulp.bd.questroom.repository.EmployeeRepository;
import nulp.bd.questroom.repository.FindoutmethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FindOutMethodService {
    @Autowired
    private FindoutmethodRepository repository;

    public List<FindOutMethod> getAll() {
        return repository.findAll();
    }

    public void save(FindOutMethod findOutMethod) {
        repository.save(findOutMethod);
    }

    public FindOutMethod get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
