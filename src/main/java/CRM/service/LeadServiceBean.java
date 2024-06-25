package CRM.service;

import CRM.domain.EmployeeEntity;
import CRM.domain.LeadEntity;
import CRM.domain.UserEntity;
import CRM.dto.LoanSearchQuery;
import CRM.repository.LeadRepository;
import CRM.repository.LeadSortingRepository;
import CRM.repository.UserRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeadServiceBean implements LeadService {

    private final LeadRepository leadRepository;
    private final UserRepository userRepository;

    private final LeadSortingRepository loanSortingRepository;

    @Override
    public LeadEntity get(Long loanId) {
        Optional<LeadEntity> optionalLoanEntity = leadRepository.findById(loanId);
        return new TemplateUtil<LeadEntity>().get(optionalLoanEntity);
    }

    @Override
    public LeadEntity edit(LeadEntity entity) {
        return leadRepository.save(entity);
    }

    @Override
    public Page<LeadEntity> page(Integer start, Integer limit) {
        Pageable paging = PageRequest.of(start, limit);

        return loanSortingRepository.findAll(paging);
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


    @Override
    public LoanSearchQuery getAssignRequestLoans(Integer start, Integer limit, String id, String assignRequestReason, String creditor, String debtor, String debtorIdentificator, String assignedAgent, BigDecimal amount, Boolean nullified, Boolean nullificationRequest, Boolean archived) {
        LoanSearchQuery loanSearchQuery = new LoanSearchQuery();
        Pageable paging = PageRequest.of(start, limit);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity currentUser = userRepository.findByUsername(authentication.getName());
        EmployeeEntity currentEmployee = currentUser.getEmployeeEntity();
        Long employeeId = currentEmployee.getId();

        return loanSearchQuery;
    }

}
