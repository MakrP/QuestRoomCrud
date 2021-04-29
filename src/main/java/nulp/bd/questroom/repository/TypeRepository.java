package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeRepository extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {

}
