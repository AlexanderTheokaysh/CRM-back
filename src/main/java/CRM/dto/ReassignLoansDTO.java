package CRM.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReassignLoansDTO {

    private List<Long> loanIds;
    private Long agentId;
    private Long visitorId;

}