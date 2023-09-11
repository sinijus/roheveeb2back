package ee.valiit.roheveeb2back.domain.image;

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
    private Integer imageId;
    @NotNull
    private byte[] imageData;
}