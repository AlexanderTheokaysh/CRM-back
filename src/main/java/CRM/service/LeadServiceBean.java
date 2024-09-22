package CRM.service;

import CRM.domain.LeadEntity;
import CRM.repository.LeadRepository;
import CRM.repository.LeadSortingRepository;
import CRM.repository.UserRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
@RequiredArgsConstructor
public class LeadServiceBean implements LeadService {

    private final LeadRepository leadRepository;
    private final UserRepository userRepository;

    private final LeadSortingRepository loanSortingRepository;


    @Override
    public LeadEntity add(LeadEntity lead) {
        String prefix = "L ";
        Pageable lastPaging = PageRequest.of(0, 1, Sort.by("id").descending());

        Page<LeadEntity> lastLead = leadRepository.getLastRecord(lastPaging);
        List<LeadEntity> leads = lastLead.getContent();
        if (leads.size() != 0) {
            int number = parseInt(leads.get(0).getUid().substring(prefix.length())) + 1;
            lead.setUid(prefix + number);
        } else {
            lead.setUid("L 1");
        }

        return leadRepository.save(lead);
    }

    @Override
    public LeadEntity edit(LeadEntity entity) {
        return leadRepository.save(entity);
    }


    @Override
    public LeadEntity get(Long clientId) {
        Optional<LeadEntity> optionalLeadEntity = leadRepository.findLeadEntityById(clientId);
        return new TemplateUtil<LeadEntity>().get(optionalLeadEntity);
    }

    @Override
    public List<List<String>> getCountries() {
        return leadRepository.getCountries();
    }

    @Override
    public Page<LeadEntity> page(String name,
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
                                   Integer limit) {
        Pageable paging = PageRequest.of(start, limit);

        return leadRepository.findLeads(name, uid, phone, mail, affiliation, lastname, registerDateFrom, registerDateTo, status, assignedAgent, gender, country, team, paging);
    }



//    public LoanSearchQuery getArchive(Integer start, Integer limit, String id, String creditor, String debtor, String debtorIdentificator, String assignedAgent, BigDecimal amount, Boolean nullified, String callDateStart, String callDateEnd, String promiseDateStart, String promiseDateEnd, Boolean nullificationRequest, Boolean archived, String status) {
//        Long localId = null;
//        LoanSearchQuery loanSearchQuery = new LoanSearchQuery();
//        Pageable paging = PageRequest.of(start, limit);
//
//        //დალოგინებული იუზერი
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserEntity currentUser = userRepository.findByUsername(authentication.getName());
//        EmployeeEntity currentEmployee = currentUser.getEmployeeEntity();
//
//
//        return loanSearchQuery;
//    }


//    @Override
//    public LoanSearchQuery getAssignRequestLoans(Integer start, Integer limit, String id, String assignRequestReason, String creditor, String debtor, String debtorIdentificator, String assignedAgent, BigDecimal amount, Boolean nullified, Boolean nullificationRequest, Boolean archived) {
//        LoanSearchQuery loanSearchQuery = new LoanSearchQuery();
//        Pageable paging = PageRequest.of(start, limit);
//
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserEntity currentUser = userRepository.findByUsername(authentication.getName());
//        EmployeeEntity currentEmployee = currentUser.getEmployeeEntity();
//        Long employeeId = currentEmployee.getId();
//
//        return loanSearchQuery;
//    }

}
