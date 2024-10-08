package CRM.service;

import CRM.domain.ClientEntity;
import CRM.dto.LoanSearchQuery;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ClientService {

    ClientEntity get(Long id);

    ClientEntity add(ClientEntity client);


    ClientEntity edit(ClientEntity client);

    List<List<String>> getCountries();

    Page<ClientEntity> page(String name,
                            String lastname,
                            String uid,
                            String phone,
                            String mail,
                            String affiliation,
                            Date registerDateFrom,
                            Date registerDateTo,
                            Long status,
                            Long assignedAgent,
                            String gender,
                            String country,
                            Long team,
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
