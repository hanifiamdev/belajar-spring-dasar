package hanifiamdev.spring.core.service;

import hanifiamdev.spring.core.repository.CategoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    @Getter
    private CategoryRepository categoryRepository;

    // contoh settera-based DI
    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

}
