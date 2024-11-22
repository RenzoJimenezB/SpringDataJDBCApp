package pe.edu.tecsup.springbootapp.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pe.edu.tecsup.springbootapp.entities.Category;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private static Logger log = LoggerFactory.getLogger(CategoryRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() throws Exception {
        return List.of();
    }
}
