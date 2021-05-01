package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Region;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RegionService {

    @Autowired
    private RegionRepository repository;

    public List<Region> getAll() {
        return repository.findAll();
    }

    public void save(Region region) {
        repository.save(region);
    }

    public Region get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }


}
