package nulp.bd.questroom.service;

import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;

    public List<Room> getAll() {
        return repository.findAll();
    }

    public void save(Room room) {
        repository.save(room);
    }

    public Room get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
