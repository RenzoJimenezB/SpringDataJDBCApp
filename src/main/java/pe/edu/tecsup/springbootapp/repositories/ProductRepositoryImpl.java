package pe.edu.tecsup.springbootapp.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("categorias_id"));
        product.setName(rs.getString("nombre"));
        product.setDescription(rs.getString("descripcion"));
        product.setPrice(rs.getDouble("precio"));
        product.setStock(rs.getInt("stock"));
        product.setImage_name(rs.getString("imagen_nombre"));
        product.setImage_type(rs.getString("imagen_tipo"));
        product.setImage_size(rs.getLong("imagen_tamanio"));
        product.setState(rs.getInt("estado"));

        return product;
    }
}

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final Logger log = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        log.info("ProductRepositoryImpl.findAll()");

        String sql = "SELECT * FROM productos";

        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
}
