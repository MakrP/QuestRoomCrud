package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Institution;
import nulp.bd.questroom.entity.Reservation;
import nulp.bd.questroom.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>, JpaSpecificationExecutor<Reservation> {
    List<Reservation> getAllByInstitutionAndRoom(Institution institution, Room room);

    @Modifying
    @Query(value = "insert into reservation_actor (Reservation_id, Actor_id, Personage_id)" +
            " VALUES (:reservationId,:actorId,:personageId)", nativeQuery = true)
    @Transactional
    void addPersonageAndActor(@Param("reservationId") Integer reservationId,
                              @Param("actorId") Integer actorId,@Param("personageId") Integer personageId);

}
