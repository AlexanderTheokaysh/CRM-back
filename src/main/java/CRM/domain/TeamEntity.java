package CRM.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TEAMS")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity leader;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "language")
    private String language;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<EmployeeEntity> teamMembers;

    @Column(name = "DESK_ID")
    private Long deskId;

}
