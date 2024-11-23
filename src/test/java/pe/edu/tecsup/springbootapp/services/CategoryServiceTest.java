package pe.edu.tecsup.springbootapp.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {
    private static Logger log = LoggerFactory.getLogger(CategoryServiceTest.class);
    
    @Autowired
    private CategoryService categoryService;

    @Test
    void findAll() throws Exception {
        categoryService.findAll();
    }
}