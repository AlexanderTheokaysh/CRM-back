package CRM.service;

import CRM.domain.LoanEntity;
import CRM.dto.LoanSearchQuery;
import CRM.dto.ReassignLoansDTO;

import java.math.BigDecimal;

public interface LoanService {

    LoanEntity get(Long id);

    LoanEntity edit(LoanEntity loan);

    LoanSearchQuery page(Integer start,
                         Integer limit,
                         String id,
                         String creditor,
                         String debtor,
                         String debtorIdentificator,
                         String assignedAgent,
                         BigDecimal amount,
                         BigDecimal amountStart,
                         BigDecimal amountEnd,
                         Boolean nullified,
                         String callDateStart,
                         String callDateEnd,
                         String promiseDateStart,
                         String promiseDateEnd,
                         Boolean nullificationRequest,
                         Boolean archived);

    LoanSearchQuery getAssignRequestLoans(Integer start,
                                          Integer limit,
                                          String id,
                                          String assignRequestReason,
                                          String creditor,
                                          String debtor,
                                          String debtorIdentificator,
                                          String assignedAgent,
                                          BigDecimal amount,
                                          Boolean nullified,
                                          Boolean nullificationRequest,
                                          Boolean archived);

    LoanSearchQuery getArchive(Integer start,
                               Integer limit,
                               String id,
                               String creditor,
                               String debtor,
                               String debtorIdentificator,
                               String assignedAgent,
                               BigDecimal amount,
                               Boolean nullified,
                               String callDateStart,
                               String callDateEnd,
                               String promiseDateStart,
                               String promiseDateEnd,
                               Boolean nullificationRequest,
                               Boolean archived,
                               String status);

    String loansToReassign(ReassignLoansDTO loans);

    void delete(Long id);
}
