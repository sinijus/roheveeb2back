package ee.valiit.roheveeb2back.business.location;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.roheveeb2back.domain.location.Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer locationId;
    private Integer countyCountyId;
    @NotNull
    @Size(max = 255)
    private String postalCode;
    @Size(max = 255)
    private String longitude;
    @Size(max = 255)
    private String latitude;
}