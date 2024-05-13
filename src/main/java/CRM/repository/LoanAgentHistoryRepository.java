package CRM.repository;

import CRM.domain.LoanAgentHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanAgentHistoryRepository extends CrudRepository<LoanAgentHistoryEntity, Long> {

    @Query("select l from LoanAgentHistoryEntity l WHERE l.loanId = :id")
    List<LoanAgentHistoryEntity> findAllByLoanId(Long id);


}
