package ee.valiit.roheveeb2back.business.category;

import ee.valiit.roheveeb2back.business.product.dto.CategoryDto;
import ee.valiit.roheveeb2back.domain.product.category.Category;
import ee.valiit.roheveeb2back.domain.product.category.CategoryMapper;
import ee.valiit.roheveeb2back.domain.product.category.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryService.getCategories();
        List<CategoryDto> categoryDtos = categoryMapper.toCategoryDtos(categories);
        return categoryDtos;
    }
}
