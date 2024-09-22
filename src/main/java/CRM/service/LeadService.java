package CRM.service;

import CRM.domain.LeadEntity;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface LeadService {

    LeadEntity get(Long id);

    LeadEntity add(LeadEntity client);


    LeadEntity edit(LeadEntity client);

    List<List<String>> getCountries();

    Page<LeadEntity> page(String name,
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
