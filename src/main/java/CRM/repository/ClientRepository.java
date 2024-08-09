package CRM.repository;

import CRM.domain.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {


    @Query("SELECT c FROM ClientEntity c WHERE :name IS null OR c.name LIKE %:name%")
    Page<ClientEntity> findClients(String name, Pageable paging);

    Optional<ClientEntity> findClientEntityById(Long id);


    @Query("SELECT c FROM ClientEntity c ORDER BY c.id DESC")
    Page<ClientEntity> getLastRecord(Pageable paging);

}
