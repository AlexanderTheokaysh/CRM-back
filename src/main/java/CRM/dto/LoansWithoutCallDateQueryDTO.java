package CRM.dto;

import CRM.domain.LeadEntity;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

@Data

public class LoansWithoutCallDateQueryDTO {

    BigDecimal totalAmount;
    Page<LeadEntity> leadEntities;
}
