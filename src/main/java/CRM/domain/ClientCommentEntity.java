package CRM.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CLIENT_COMMENTS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientCommentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "comment", length = 2000)
    private String comment;

    @Column(name = "date")
    private Date date;

    @Column(name = "author")
    private String author;

}
