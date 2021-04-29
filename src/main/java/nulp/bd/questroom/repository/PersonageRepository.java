package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Personage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonageRepository extends JpaRepository<Personage, Integer>, JpaSpecificationExecutor<Personage> {

}
