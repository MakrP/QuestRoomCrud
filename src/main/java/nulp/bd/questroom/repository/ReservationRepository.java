package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Reservation;
import nulp.bd.questroom.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>, JpaSpecificationExecutor<Reservation> {
    List<Reservation> getAllByInstitutionAndRoom(Institution institution, Room room);
}
