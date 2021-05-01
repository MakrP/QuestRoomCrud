package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.FindOutMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FindoutmethodRepository extends JpaRepository<FindOutMethod, Integer>, JpaSpecificationExecutor<FindOutMethod> {

}
