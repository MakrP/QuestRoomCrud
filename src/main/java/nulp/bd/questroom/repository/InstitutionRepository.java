package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Integer>, JpaSpecificationExecutor<Institution> {

    @Query("SELECT distinct city from Institution")
    List<String> getCities();
    List<Institution> getAllByCity(String city);
}
