package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Promouter;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.repository.PromouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PromouterService {
    @Autowired
    private PromouterRepository repository;

    public List<Promouter> getAll() {
        return repository.findAll();
    }

    public void save(Promouter promouter) {
        repository.save(promouter);
    }

    public Promouter get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
