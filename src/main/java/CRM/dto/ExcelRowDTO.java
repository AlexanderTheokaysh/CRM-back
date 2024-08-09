package CRM.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExcelRowDTO {

    private String legalAddress;
    private String physicalAddress;
    private String email;
    private String contact;
    private String phone;
    private String personalNumber;

    private String firstname;
    private String lastname;

    private String idCode;
    private BigDecimal initialAmount;
    private BigDecimal amount;
    private Date startDate;
    private Date incomeDate;

}
