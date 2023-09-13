package ee.valiit.roheveeb2back.business.product.dto;

import ee.valiit.roheveeb2back.domain.product.category.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Category}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private Integer categoryId;
    @NotNull
    @Size(max = 255)
    private String categoryName;
}