package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InstitutionRepository extends JpaRepository<Institution, Integer>, JpaSpecificationExecutor<Institution> {

}
