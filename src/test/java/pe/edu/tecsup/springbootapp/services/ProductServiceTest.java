package pe.edu.tecsup.springbootapp.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceTest.class);

    @Autowired
    private ProductService productService;

    @Test
    void findAll() throws Exception {
        log.info("Testing ProductService.getProducts()");

        List<Product> products = productService.getProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(product -> System.out.println(product.getName()));
        products.forEach(System.out::println);
    }
}