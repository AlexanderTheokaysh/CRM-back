package CRM.repository;

import CRM.domain.LeadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LeadRepository extends JpaRepository<LeadEntity, Long> {


    @Query("SELECT c FROM ClientEntity c left join " +
            "StatusEntity s on c.status.id = s.id  left join " +
            "EmployeeEntity e on e.id = c.assignedTo.id where " +
            "(:name IS null OR c.name LIKE %:name%) AND " +
            "(:uid is null OR c.uid = :uid) AND " +
            "(:phone is null OR c.phone LIKE %:phone) AND " +
            "(:mail is null OR c.email LIKE %:mail%) AND " +
            "(:affiliation is null OR c.affiliation LIKE %:affiliation%) AND " +
            "(:lastname IS NULL OR c.lastname LIKE %:lastname) AND " +
            "(:registerDateFrom IS NULL OR c.registerDate BETWEEN :registerDateFrom AND :registerDateTo) AND " +
            "(:status is null or c.status.id = :status) AND " +
            "(:assignedAgent is null or e.id = :assignedAgent) AND " +
            "(:gender is null or c.gender = :gender) AND " +
            "(:country is null or c.country = :country) AND " +
            "(:team is null or e.teamId = :team)")
    Page<LeadEntity> findLeads(String name,
                                   String uid,
                                   String phone,
                                   String mail,
                                   String affiliation,
                                   String lastname,
                                   Date registerDateFrom,
                                   Date registerDateTo,
                                   Long status,
                                   Long assignedAgent,
                                   String gender,
                                   String country,
                                   Long team,
                                   Pageable paging);


    @Query("Select distinct l.country, l.countryCode from LeadEntity l")
    List<List<String>> getCountries();


    Optional<LeadEntity> findLeadEntityById(Long id);


    @Query("SELECT l FROM LeadEntity l ORDER BY l.id DESC")
    Page<LeadEntity> getLastRecord(Pageable paging);

}
