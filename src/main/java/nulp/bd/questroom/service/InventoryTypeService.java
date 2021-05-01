package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.InventoryType;
import nulp.bd.questroom.entity.Promouter;
import nulp.bd.questroom.repository.InverntoryTypeRepository;
import nulp.bd.questroom.repository.PromouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InventoryTypeService {
    @Autowired
    private InverntoryTypeRepository repository;

    public List<InventoryType> getAll() {
        return repository.findAll();
    }

    public void save(InventoryType inventoryType) {
        repository.save(inventoryType);
    }

    public InventoryType get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
