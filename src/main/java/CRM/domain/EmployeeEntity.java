package CRM.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", columnDefinition = "nvarchar(30)")
    private String firstName;

    @Column(name = "PROFILE_PHOTO")
    private String profilePhoto;

    @Column(name = "LAST_NAME", length = 20)
    private String lastName;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "DESK_ID")
    private Long managerForDeskId;
}