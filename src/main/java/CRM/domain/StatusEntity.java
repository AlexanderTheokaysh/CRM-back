package CRM.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "STATUS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

}