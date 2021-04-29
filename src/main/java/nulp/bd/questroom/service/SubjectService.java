package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Employee;
import nulp.bd.questroom.entity.Subject;
import nulp.bd.questroom.repository.EmployeeRepository;
import nulp.bd.questroom.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;

    public List<Subject> getAll() {
        return repository.findAll();
    }

    public void save(Subject subject) {
        repository.save(subject);
    }

    public Subject get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
