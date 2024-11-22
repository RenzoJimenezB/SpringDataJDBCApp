package pe.edu.tecsup.springbootapp.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private static Logger log = LoggerFactory.getLogger(CategoryRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() throws Exception {
        log.info("CategoryRepositoryImpl.findAll()");

        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setId(1L);
        category.setName("Laptops");
        category.setOrder(1);

        categories.add(category);
        return categories;
    }
}
