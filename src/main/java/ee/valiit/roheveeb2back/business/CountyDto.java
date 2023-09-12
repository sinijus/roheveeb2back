package ee.valiit.roheveeb2back.business;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.roheveeb2back.domain.county.County}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyDto implements Serializable {
    private Integer countyId;
    @NotNull
    @Size(max = 255)
    private String countyName;
}