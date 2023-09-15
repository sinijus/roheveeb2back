package ee.valiit.roheveeb2back.business.type.dto;

import ee.valiit.roheveeb2back.domain.product.type.Type;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Type}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeRequest implements Serializable {
    private Integer categoryId;
    @NotNull
    @Size(max = 255)
    private String typeName;
}