package CRM.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanPaymentsSearchQuery {
     BigDecimal totalAmount;
     BigDecimal paymentCount;
     BigDecimal withCheckAmount;
     BigDecimal totalExtraPaid;
//     Page<LoanEntity> loanEntities;
}
