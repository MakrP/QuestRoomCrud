package nulp.bd.questroom.repository;

import nulp.bd.questroom.entity.InventoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InverntoryTypeRepository extends JpaRepository<InventoryType, Integer>, JpaSpecificationExecutor<InventoryType> {

}
