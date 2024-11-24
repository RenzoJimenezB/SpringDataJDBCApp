package pe.edu.tecsup.springbootapp.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CategoryServiceTest {

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