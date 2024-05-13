package CRM.service;

import CRM.repository.LoanAgentHistoryRepository;
import CRM.domain.LoanAgentHistoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanAgentHistoryServiceBean implements LoanAgentHistoryService {

    private final LoanAgentHistoryRepository loanAgentHistoryRepository;


    @Override
    public LoanAgentHistoryEntity edit(LoanAgentHistoryEntity entity) {
        return loanAgentHistoryRepository.save(entity);
    }

    @Override
    public LoanAgentHistoryEntity get(Long id) {
        return null;
    }

    @Override
    public List<LoanAgentHistoryEntity> list(Long id) {
        return loanAgentHistoryRepository.findAllByLoanId(id);
    }


    @Override
    public void delete(Long id) {

    }
}
