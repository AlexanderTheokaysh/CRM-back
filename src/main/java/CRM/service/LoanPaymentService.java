package CRM.service;

import CRM.domain.LoanPaymentEntity;
import CRM.dto.LoanPaymentsSearchQuery;
import CRM.dto.LoanPromisesSearchQuery;
import CRM.dto.LoansWithoutCallDateQueryDTO;

import java.util.List;

public interface LoanPaymentService {

    LoanPaymentEntity get(Long id);

    LoanPaymentEntity edit(LoanPaymentEntity entity);

    List<LoanPaymentEntity> list(Long id);

    LoanPaymentsSearchQuery page(Integer start,
                                 Integer limit,
                                 String creditor,
                                 String id,
                                 String debtor,
                                 String debtorIdentificator,
                                 String assignedAgent,
                                 Long amountStart,
                                 Long amountEnd,
                                 String dateStart,
                                 String dateEnd,
                                 Boolean withCheck);
    LoanPromisesSearchQuery getPromiseLoans(Integer start,
                                            Integer limit,
                                            String creditor,
                                            String id,
                                            String debtor,
                                            String debtorIdentificator,
                                            String assignedAgent,
                                            Long amountStart,
                                            Long amountEnd,
                                            String dateStart,
                                            String dateEnd,
                                            Boolean withCheck);
    LoansWithoutCallDateQueryDTO getLoansWithoutCallDate(Integer start,
                                                         Integer limit,
                                                         String creditor,
                                                         String id,
                                                         String debtor,
                                                         String debtorIdentificator,
                                                         String assignedAgent,
                                                         Long amountStart,
                                                         Long amountEnd,
                                                         String dateStart,
                                                         String dateEnd,
                                                         Boolean withCheck);


    List<LoanPaymentEntity> deniedList(Long id);

    void delete(Long id);
}
