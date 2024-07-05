package CRM.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "client_this_month")
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
}
