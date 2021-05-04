package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {

    @Modifying
    @Query(value = "insert into actor_personage (Actor_id, Personage_id)" +
            " VALUES (:actorId,:personageId)", nativeQuery = true)
    @Transactional
void addNewPersonageToActor(@Param("actorId") Integer actorId, @Param("personageId") Integer personageId);

}
