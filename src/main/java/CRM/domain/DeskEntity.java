package CRM.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DESKS")
public class DeskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<EmployeeEntity> deskManagers;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "DESK_ID")
    private List<TeamEntity> teams;
}
