package de.vignold.vignoldmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.vignold.vignoldmanagement.entity.state.State;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("job")
    private JobDTO jobDTO;

    @JsonProperty("description")
    private String description;

    @JsonProperty("deleted")
    private Boolean deleted;

    @JsonProperty("state")
    private State state;

    @JsonProperty("createdDate")
    private ZonedDateTime createdDate;

    @JsonProperty("updatedDate")
    private ZonedDateTime updatedDate;

   /* @JsonProperty("operatorId")
    private int operatorId;*/
}
