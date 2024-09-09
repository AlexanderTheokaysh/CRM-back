package CRM.repository;

import CRM.domain.DeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeskRepository extends JpaRepository<DeskEntity, Long> {

}



