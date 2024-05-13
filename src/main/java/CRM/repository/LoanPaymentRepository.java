package CRM.repository;

import CRM.domain.LoanPaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanPaymentRepository extends CrudRepository<LoanPaymentEntity, Long> {

    @Query("select l from LoanPaymentEntity l WHERE l.loanId = :id AND l.deniedPayment = false ")
    List<LoanPaymentEntity> findAllByLoanId(Long id);

    @Query("select l from LoanPaymentEntity l WHERE l.loanId = :id AND l.deniedPayment = true ")
    List<LoanPaymentEntity> findDeniedPayments(Long id);

}
