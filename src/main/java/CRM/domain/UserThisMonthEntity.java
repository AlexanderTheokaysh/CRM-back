package CRM.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_monthly_report")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserThisMonthEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "target")
    private Long target;

    @Column(name = "ftd_amount")
    private Long ftdAmount;

    @Column(name = "month")
    private String month;

    @Column(name = "upsaleAmount")
    private Long upsaleAmount;


}
