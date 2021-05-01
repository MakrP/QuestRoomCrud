package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.Status;
import nulp.bd.questroom.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StatusService {
    @Autowired
    private StatusRepository repository;

    public List<Status> getAll() {
        return repository.findAll();
    }

    public void save(Status status) {
        repository.save(status);
    }

    public Status get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Status getByTitle(String title) {
        return repository.getStatusByTitle(title);
    }
}
