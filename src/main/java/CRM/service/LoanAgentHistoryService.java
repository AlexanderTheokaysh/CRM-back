package CRM.service;

import CRM.domain.LoanAgentHistoryEntity;

import java.util.List;

public interface LoanAgentHistoryService {

    LoanAgentHistoryEntity get(Long id);

    LoanAgentHistoryEntity edit(LoanAgentHistoryEntity entity);


    List<LoanAgentHistoryEntity> list(Long loanId);

    void delete(Long id);

}
