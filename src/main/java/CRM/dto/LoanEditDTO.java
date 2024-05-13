package CRM.dto;

import CRM.domain.LoanEntity;
import lombok.Data;

@Data
public class LoanEditDTO {

    private LoanEntity loanEntity;

    private String assignedEmployeeId;

    private String visitorId;

}
