package CRM.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CLIENTS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<ClientCommentEntity> comments;

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

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "gender")
    private String gender;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "is_online")
    private Boolean isOnline;

    @ManyToOne
    private EmployeeEntity assignedTo;

    @Column(name = "trades")
    private String trades;

    @Column(name = "ftd_agent")
    private String ftdAgent;

    @Column(name = "account")
    private String account;

    @Column(name = "personal_data")
    private String personalData;

    @Column(name = "affiliation")
    private String affiliation;

    @Column(name = "source")
    private String source;

    @Column(name = "deposit")
    private Boolean deposit;

    @Column(name = "last_online")
    private Date lastOnline;

    @ManyToOne
    private StatusEntity status;


}