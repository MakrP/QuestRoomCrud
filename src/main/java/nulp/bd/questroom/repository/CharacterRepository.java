package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CharacterRepository extends JpaRepository<Character, Integer>, JpaSpecificationExecutor<Character> {

}
