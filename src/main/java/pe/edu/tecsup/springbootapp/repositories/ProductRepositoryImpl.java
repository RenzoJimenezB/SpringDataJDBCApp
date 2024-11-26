package pe.edu.tecsup.springbootapp.repositories;

import lombok.extern.slf4j.Slf4j;
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
        product.setCategoryId(rs.getLong("categorias_id"));
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

@Slf4j
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Product product) {
        log.info("ProductRepositoryImpl.save()");

        String sql = """
                INSERT INTO productos (categorias_id, nombre,
                descripcion, precio, stock, estado,
                imagen_nombre, imagen_tipo,
                imagen_tamanio)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                product.getCategoryId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getState(),
                product.getImage_name(),
                product.getImage_type(),
                product.getImage_size());
    }

    @Override
    public List<Product> findAll() {
        log.info("ProductRepositoryImpl.findAll()");

        String sql = """
                SELECT
                    p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio,
                    p.id, p.categorias_id, p.nombre, p.descripcion,
                    p.precio, p.stock, p.creado, p.estado,
                    c.nombre AS categorias_nombre
                FROM productos p
                INNER JOIN categorias c ON c.id = p.categorias_id
                WHERE estado = 1
                ORDER BY id
                """;

        List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());

        log.info("All products: ");
        products.forEach(System.out::println);

        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        log.info("ProductRepositoryImpl.findByName()");

        String sql = """
                SELECT
                    p.id, p.nombre, p.descripcion, p.precio, p.stock,
                    p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio,
                    p.creado, p.estado, p.categorias_id,
                    c.nombre AS categorias_nombre
                FROM productos p
                INNER JOIN categorias c ON c.id = p.categorias_id
                WHERE p.estado = 1 AND upper(p.nombre) LIKE upper(?)
                ORDER BY p.id
                """;

        Object[] parameters = new Object[]{"%" + name + "%"};
        List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper(), parameters);

        log.info("Products with name '{}':", name);
        products.forEach(System.out::println);

        return products;
    }

    @Override
    public Product findById(Long id) {
        log.info("ProductRepositoryImpl.findById()");

        String sql = """
                SELECT p.id, p.categorias_id, c.nombre AS
                categorias_nombre, p.nombre, p.estado,
                p.descripcion, p.precio, p.stock,
                p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio,
                p.creado
                FROM productos p
                INNER JOIN categorias c ON c.id =
                p.categorias_id
                WHERE estado = 1 AND p.id = ?
                """;

        Object[] parameter = new Object[]{id};
        Product product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), parameter);

        log.info("Product with ID {}:", id);
        System.out.println(product);

        return product;
    }

    @Override
    public List<Product> findByCategoryOrName(Long categoryId, String name) throws Exception {
        log.info("ProductRepositoryImpl.findByCategoryOrName()");

        String sql = """
                SELECT
                    p.id, p.nombre, p.descripcion, p.precio, p.stock,
                    p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio,
                    p.creado, p.estado, p.categorias_id,
                    c.nombre AS categorias_nombre
                FROM productos p
                INNER JOIN categorias c ON c.id = p.categorias_id
                WHERE estado = 1
                AND (? IS NULL OR p.categorias_id = ?)
                AND (? IS NULL OR upper(p.nombre) LIKE upper(?))
                """;

        Object[] parameters = new Object[]{categoryId, categoryId, name, "%" + name + "%"};
        List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper(), parameters);

        if (products.isEmpty()) {
            throw new Exception("No products found for the given criteria");
        }

        log.info("Products found:");
        products.forEach(System.out::println);

        return products;
    }

    @Override
    public void update(Long id, String productName) {
        log.info("ProductRepositoryImpl.update()");

        String sql = """
                UPDATE productos
                SET nombre = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(sql, productName, id);
    }

    @Override
    public void deleteById(Long id) {
        log.info("ProductRepositoryImpl.deleteById()");

        String sql = """
                DELETE FROM productos
                WHERE id = ?
                """;

        jdbcTemplate.update(sql, id);
    }
}
