package CRM.service;

import CRM.domain.ClientEntity;
import CRM.dto.LoanSearchQuery;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface ClientService {

    ClientEntity get(Long id);

    ClientEntity edit(ClientEntity client);

    Page<ClientEntity> page(Integer start,
                          Integer limit);

    LoanSearchQuery getAssignRequestLoans(Integer start, Integer limit, String id, String assignRequestReason, String creditor, String debtor, String debtorIdentificator, String assignedAgent, BigDecimal amount, Boolean nullified, Boolean nullificationRequest, Boolean archived);


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
