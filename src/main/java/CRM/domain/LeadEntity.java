package CRM.domain;

import lombok.*;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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

    @OneToMany
    @JoinColumn(name = "LEAD_ID")
    private List<LeadCommentEntity> comments;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;


    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "test_seq")
    @GenericGenerator(name = "test_seq", strategy = "StringPrefixedSequenceIdGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "5"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INITIAL_PARAM, value = "0"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled-hi")})
    @Column(name = "UID")
    public String uid;


    @Column(name = "phone")
    private String phone;


    @Column(name = "gender")
    private String gender;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "is_online")
    private Boolean isOnline;

//    @ManyToOne
//    private EmployeeEntity assignedTo;

    @Column(name = "trades")
    private String trades;

    @Column(name = "account")
    private String account;

    @Column(name = "personal_data")
    private String personalData;

    @Column(name = "deposit")
    private Boolean deposit;

    @Column(name = "last_online")
    private Date lastOnline;

    public static class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator {

        public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
        public static final String VALUE_PREFIX_DEFAULT = "1";
        private String valuePrefix;

        public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
        public static final String NUMBER_FORMAT_DEFAULT = "%d";
        private String numberFormat;

        @Override
        public Serializable generate(SharedSessionContractImplementor session,
                                     Object object) throws HibernateException {
            return valuePrefix
                    + String.format(numberFormat, super.generate(session, object));
        }

        @Override
        public void configure(Type type, Properties params,
                              ServiceRegistry serviceRegistry) throws MappingException {
            super.configure(StringType.INSTANCE, params, serviceRegistry);
            valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,
                    params, VALUE_PREFIX_DEFAULT);
            numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                    params, NUMBER_FORMAT_DEFAULT);
        }
    }
}
