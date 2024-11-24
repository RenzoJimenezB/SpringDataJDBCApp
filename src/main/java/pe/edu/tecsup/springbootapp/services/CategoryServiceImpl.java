package pe.edu.tecsup.springbootapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.springbootapp.entities.Category;
import pe.edu.tecsup.springbootapp.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() throws Exception {
        log.info("CategoryServiceImpl.getCategories()");

        return categoryRepository.findAll();
    }
}
