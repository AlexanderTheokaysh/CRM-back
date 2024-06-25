package CRM.dto;

import CRM.domain.LeadEntity;
import lombok.Data;

@Data
public class LoanEditDTO {

    private LeadEntity leadEntity;

    private String assignedEmployeeId;

    private String visitorId;

}
