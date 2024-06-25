package CRM.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanPromisesSearchQuery {
    BigDecimal totalAmount;
    BigDecimal totalPromiseAmount;
//    Page<LoanEntity> loanEntities;
}
