package ee.valiit.roheveeb2back.business.register.dto;

import ee.valiit.roheveeb2back.domain.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto implements Serializable {
    private Integer id;
    @NotNull
    private byte[] data;
}