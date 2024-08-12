package CRM.service;

import CRM.domain.ClientEntity;
import CRM.dto.LoanSearchQuery;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;

public interface ClientService {

    ClientEntity get(Long id);

    ClientEntity add(ClientEntity client);


    ClientEntity edit(ClientEntity client);

    Page<ClientEntity> page(String name,
                            String lastname,
                            String uid,
                            String phone,
                            String mail,
                            Date registerDateFrom,
                            Date registerDateTo,
                            Long status,
                            Long assignedAgent,
                            Boolean gender,
                            String country,
                            Integer start,
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
