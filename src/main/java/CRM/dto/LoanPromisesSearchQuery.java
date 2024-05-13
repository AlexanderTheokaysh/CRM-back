package CRM.dto;

import CRM.domain.LoanEntity;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Data
public class LoanPromisesSearchQuery {
    BigDecimal totalAmount;
    BigDecimal totalPromiseAmount;
    Page<LoanEntity> loanEntities;
}
