package pe.edu.tecsup.springbootapp.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceTest.class);

    @Autowired
    private CategoryService categoryService;

    @Test
    void findAll() throws Exception {
        log.info("Testing CategoryService.getCategories()");

        List<Category> categories = categoryService.getCategories();

        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        assertFalse(categories.contains(null));

        categories.forEach(category -> System.out.println(category.getName()));
        categories.forEach(System.out::println);
    }
}