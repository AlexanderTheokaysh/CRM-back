package CRM.repository;

import CRM.domain.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("select l from UserEntity l WHERE l.username = :username")
    UserEntity findByUsername(String username);

}
