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

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity deskManager;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "DESK_ID")
    private List<TeamEntity> teams;
}
