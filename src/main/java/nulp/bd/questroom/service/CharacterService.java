package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Character;
import nulp.bd.questroom.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CharacterService {
    @Autowired
    private CharacterRepository repository;

    public List<Character> getAll() {
        return repository.findAll();
    }

    public void save(Character character) {
        repository.save(character);
    }

    public Character get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
