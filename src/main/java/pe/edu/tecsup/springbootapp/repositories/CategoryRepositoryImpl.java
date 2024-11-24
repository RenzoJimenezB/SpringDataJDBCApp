package pe.edu.tecsup.springbootapp.repositories;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Process each row of the query
 */
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

@Slf4j
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> findAll() {
        log.info("CategoryRepositoryImpl.findAll()");

        String sql = "SELECT * FROM categorias";

        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }
}
