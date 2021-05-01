package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Inventory;
import nulp.bd.questroom.entity.InventoryType;
import nulp.bd.questroom.repository.InventoryRepository;
import nulp.bd.questroom.repository.InverntoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;

    public List<Inventory> getAll() {
        return repository.findAll();
    }

    public void save(Inventory inventory) {
        repository.save(inventory);
    }

    public Inventory get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
