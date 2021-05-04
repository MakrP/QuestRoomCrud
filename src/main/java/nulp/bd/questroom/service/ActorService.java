package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.Actor;
import nulp.bd.questroom.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ActorService {
    @Autowired
    private ActorRepository repository;

    public List<Actor> getAll() {
        return repository.findAll();
    }

    public void save(Actor actor) {
        repository.save(actor);
    }

    public Actor get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void addNewPersonageToActor(int actorId, int personageId) {
        repository.addNewPersonageToActor(actorId,personageId);
    }
}
