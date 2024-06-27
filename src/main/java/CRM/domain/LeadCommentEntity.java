package CRM.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "LEAD_COMMENTS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "comment", length = 2000)
    private String comment;

    @Column(name = "date")
    private Date date;

    @Column(name = "author")
    private String author;

    @ManyToOne
    private LeadCommentEntity lead;

}
