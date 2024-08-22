package CRM.repository;

import CRM.domain.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.Optional;

public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {


    @Query("SELECT c FROM ClientEntity c left join " +
            "StatusEntity s on c.status.id = s.id  left join " +
            "EmployeeEntity e on e.id = c.assignedTo.id where " +
            "(:name IS null OR c.name LIKE %:name%) AND " +
            "(:uid is null OR c.uid = :uid) AND " +
            "(:phone is null OR c.phone LIKE %:phone) AND " +
            "(:mail is null OR c.email LIKE %:mail%) AND " +
            "(:affiliate is null OR c.affiliation LIKE %:affiliate%) AND " +
            "(:lastname IS NULL OR c.lastname LIKE %:lastname) AND " +
            "(:registerDateFrom IS NULL OR c.registerDate BETWEEN :registerDateFrom AND :registerDateTo) AND " +
            "(:status is null or c.status.id = :status) AND " +
            "(:assignedAgent is null or e.id = :assignedAgent) AND " +
            "(:gender is null or c.gender = :gender) AND " +
            "(:country is null or c.country = :country) AND " +
            "(:team is null or e.teamId = :team)")
    Page<ClientEntity> findClients(String name,
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



    Optional<ClientEntity> findClientEntityById(Long id);


    // @Query("SELECT l FROM LoanEntity l " +
    //            "left join l.creditorOrganization co ON l.creditorOrganization.id = co.id " +
    //            "left join l.debtorOrganization do ON l.debtorOrganization.id = do.id " +
    //            "left join l.debtorPerson dp ON l.debtorPerson.id = dp.id " +
    //            "left join l.assignedAgent aA ON l.assignedAgent.id = aA.id " +
    //            "WHERE l.assignedAgent = :currentUser AND " +
    //            "l.nullified =:nullified AND " +
    //            "l.nullificationRequest =:nullificationRequest AND " +
    //            "l.archived =:archived AND " +
    //            "(:formattedCallDateStart IS NULL OR l.callDate BETWEEN :formattedCallDateStart AND :formattedCallDateEnd) AND " +
    //            "(:formattedPromiseDateStart IS NULL OR l.promiseDate BETWEEN :formattedPromiseDateStart AND :formattedPromiseDateEnd) AND " +
    //            "(:amountStart IS NULL OR l.amount > :amountStart) AND " +
    //            "(:amountEnd IS NULL OR l.amount < :amountEnd) AND " +
    //            "(:localId IS NULL OR l.id = :localId) AND " +
    //            "(:amount IS NULL OR l.amount = :amount) AND " +
    //            "(:creditor IS NULL OR co.orgName LIKE %:creditor%) AND " +
    //            "(:assignedAgent IS NULL OR (CONCAT(aA.firstName,aA.lastName) LIKE %:assignedAgent%)) AND " +
    //            "(:debtorIdentificator IS NULL OR (dp.personalNumber LIKE %:debtorIdentificator% OR do.cadastrialCode LIKE %:debtorIdentificator%)) AND " +
    //            "(:debtor IS NULL OR (CONCAT(dp.firstname,dp.lastname) LIKE %:debtor% OR do.orgName LIKE %:debtor%))")


    @Query("SELECT c FROM ClientEntity c ORDER BY c.id DESC")
    Page<ClientEntity> getLastRecord(Pageable paging);

}
