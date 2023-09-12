package ee.valiit.roheveeb2back.business.dto;

import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link MeasureUnit}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasureUnitDto implements Serializable {
    private Integer measureId;
    @NotNull
    @Size(max = 255)
    private String measureName;
}