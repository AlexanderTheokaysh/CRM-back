package CRM.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "LEADS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;


    @Column(name = "email")
    private String email;


    @Column(name = "UID")
    private String uid;


    @Column(name = "phone")
    private String phone;


    @Column(name = "gender")
    private String gender;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "is_online")
    private Boolean isOnline;

    @ManyToOne
    @Column(name = "assigned_to")
    private EmployeeEntity assignedTo;

    @Column(name = "trades")
    private String trades;

    @Column(name = "comments")
    private String comments;

    @Column(name = "account")
    private String account;

    @Column(name = "personal_data")
    private String personalData;

    @Column(name = "deposit")
    private Boolean deposit;

    @Column(name = "last_online")
    private Date lastOnline;


}
