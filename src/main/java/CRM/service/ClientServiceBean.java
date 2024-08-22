package CRM.service;

import CRM.domain.ClientEntity;
import CRM.domain.EmployeeEntity;
import CRM.domain.UserEntity;
import CRM.dto.LoanSearchQuery;
import CRM.repository.ClientRepository;
import CRM.repository.UserRepository;
import CRM.utils.TemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
@RequiredArgsConstructor
public class ClientServiceBean implements ClientService {


    private final UserRepository userRepository;

    private final ClientRepository clientRepository;

    @Override
    public ClientEntity get(Long clientId) {
        Optional<ClientEntity> optionalClientEntity = clientRepository.findClientEntityById(clientId);
        return new TemplateUtil<ClientEntity>().get(optionalClientEntity);
    }

    @Override
    public ClientEntity add(ClientEntity client) {
        String prefix = "C ";
        Pageable lastPaging = PageRequest.of(0, 1, Sort.by("id").descending());

        Page<ClientEntity> lastClient = clientRepository.getLastRecord(lastPaging);
        List<ClientEntity> clients = lastClient.getContent();
        if (clients.size() != 0) {
            int number = parseInt(clients.get(0).getUid().substring(prefix.length())) + 1;
            client.setUid(prefix + number);
        } else {
            client.setUid("C 1");
        }

        return clientRepository.save(client);
    }

    @Override
    public ClientEntity edit(ClientEntity entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Page<ClientEntity> page(String name,
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

        return clientRepository.findClients(name, uid, phone, mail, affiliation, lastname, registerDateFrom, registerDateTo, status, assignedAgent, gender, country, team, paging);
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
