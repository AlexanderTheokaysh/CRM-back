package CRM.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "SYSTEM_USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "DEACTIVATE_DATE")
    private Date deactivateDate;

    @OneToOne
    private EmployeeEntity employeeEntity;

}
