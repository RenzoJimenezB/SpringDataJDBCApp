package pe.edu.tecsup.springbootapp.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

        Category category = new Category();
        category.setId(rs.getLong("id"));
        category.setName(rs.getString("nombre"));
        category.setOrder(rs.getInt("orden"));

        return category;
    }
}

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private static Logger log = LoggerFactory.getLogger(CategoryRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() throws Exception {
        log.info("CategoryRepositoryImpl.findAll()");

        String sql = "SELECT * FROM categorias";

        List<Category> categories = jdbcTemplate.query(sql, new CategoryRowMapper());
        return categories;
    }
}
