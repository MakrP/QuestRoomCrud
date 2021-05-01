package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Promouter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PromouterRepository extends JpaRepository<Promouter, Integer>, JpaSpecificationExecutor<Promouter> {

}
