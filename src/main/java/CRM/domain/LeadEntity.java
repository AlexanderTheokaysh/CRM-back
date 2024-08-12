package CRM.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "LEADS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LeadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="lead_id")
    private List<LeadCommentEntity> comments;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "UID", nullable = false)
    public String uid;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "is_online")
    private Boolean isOnline;

    @Column(name = "country")
    private String country;

    @ManyToOne
    private EmployeeEntity assignedTo;

    @Column(name = "deposit")
    private Boolean deposit;

    @Column(name = "affiliation")
    private String affiliation;

    @Column(name = "source")
    private String source;

    @ManyToOne
    private StatusEntity status;
}
