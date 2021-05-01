package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.State;
import nulp.bd.questroom.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StateService {
    @Autowired
    private StateRepository repository;

    public List<State> getAll() {
        return repository.findAll();
    }

    public void save(State state) {
        repository.save(state);
    }

    public State get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
