package ee.valiit.roheveeb2back.business.category;


import ee.valiit.roheveeb2back.business.product.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;
    @GetMapping("/categories")
    @Operation(summary = " Leiab süsteemist (andmebaasi category tabelist) kõik kategooriad.",
            description = """
                     Tagastab info koos categoryId ja categoryName'ga
                    """)
    public List<CategoryDto> getCategories() {
        return categoriesService.getCategories();
    }
}
