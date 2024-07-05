package CRM.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
public class LeadEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "LEAD_ID")
    private List<LeadCommentEntity> comments;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(generator = "CustomLeadIDGenerator", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "CustomLeadIDGenerator", strategy = "CRM.utils.CustomLeadIDGenerator")
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

//    @ManyToOne
//    private EmployeeEntity assignedTo;

    @Column(name = "deposit")
    private Boolean deposit;

    @ManyToOne
    private StatusEntity status;
}
