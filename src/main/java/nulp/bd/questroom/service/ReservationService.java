package nulp.bd.questroom.service;


import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Reservation;
import nulp.bd.questroom.entity.Room;
import nulp.bd.questroom.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public void save(Reservation reservation) {
        repository.save(reservation);
    }

    public Reservation get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Reservation> getByInstitutionAndRoom(Institution institution, Room room) {
        return repository.getAllByInstitutionAndRoom(institution, room);
    }

    public void addPersonageAndActor( Integer reservationId, Integer actorId, Integer personageId) {
        repository.addPersonageAndActor(reservationId,actorId,personageId);
    }


}
