package de.vignold.vignoldmanagement.entity;

import de.vignold.vignoldmanagement.entity.state.State;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Table(
        name = "product",
        uniqueConstraints = @UniqueConstraint(name = "uc_productid", columnNames = {"id"})
)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private Job job;

    @Column(nullable = false)
    @NotNull(message = "Job description can not be null!")
    private String description;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column(nullable = false)
    @NotNull(message = "State can not be null!")
    private State state;

   /* @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime updatedDate = ZonedDateTime.now();*/

  /*  @Column
    @NotEmpty(message = "State can not be null or empty!")
    private int operatorId;*/
}
