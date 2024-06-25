package CRM.service;

import CRM.domain.LeadEntity;
import CRM.dto.LoanSearchQuery;
import CRM.dto.ReassignLoansDTO;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface LeadService {

    LeadEntity get(Long id);

    LeadEntity edit(LeadEntity lead);

    Page<LeadEntity> page(Integer start,
                          Integer limit);

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

//    LoanSearchQuery getArchive(Integer start,
//                               Integer limit,
//                               String id,
//                               String creditor,
//                               String debtor,
//                               String debtorIdentificator,
//                               String assignedAgent,
//                               BigDecimal amount,
//                               Boolean nullified,
//                               String callDateStart,
//                               String callDateEnd,
//                               String promiseDateStart,
//                               String promiseDateEnd,
//                               Boolean nullificationRequest,
//                               Boolean archived,
//                               String status);


}
