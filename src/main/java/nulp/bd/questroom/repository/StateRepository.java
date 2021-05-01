package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StateRepository extends JpaRepository<State, Integer>, JpaSpecificationExecutor<State> {

}
