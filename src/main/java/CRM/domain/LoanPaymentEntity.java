package CRM.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LOAN_PAYMENT")
public class LoanPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "PAY_DATE")
    private Date date;

    @Column(name = "PAYED")
    private Boolean payed;

    @Column(name="loan_id")
    private Long loanId;

    @Column(name="with_check")
    private Boolean withCheck;

    @Column(name="denied_payment")
    private Boolean deniedPayment;

    @Column(name="comment", length = 10000)
    private String comment;

    @Column(name="author")
    private String author;

}
