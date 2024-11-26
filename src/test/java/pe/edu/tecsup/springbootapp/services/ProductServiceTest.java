package pe.edu.tecsup.springbootapp.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void save() throws Exception {
        log.info("Testing ProductService.save()");

        List<Product> products = productService.getProducts();
        int totalBefore = products.size();

        Product product = new Product();
        product.setCategoryId(1L);
        product.setName("AMD");
        product.setDescription("AMD X10");
        product.setPrice(280.0);
        product.setStock(6);
        product.setState(1);

        productService.save(product);

        products = productService.getProducts();
        int totalAfter = products.size();
        assertEquals(1, totalAfter - totalBefore);
    }

    @Test
    void getProducts() throws Exception {
        log.info("Testing ProductService.getProducts()");

        List<Product> products = productService.getProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void findByName() throws Exception {
        log.info("Testing ProductService.getProductsByName()");

        List<Product> products = productService.findByName("Test");
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void findById() throws Exception {
        log.info("Testing ProductService.getProductById()");

        String EXPECTED_NAME = "NVIDIA";
        Long id = 20L;
        Product product = productService.findById(id);

        log.info(product.toString());
        assertEquals(EXPECTED_NAME, product.getName());
    }

    @Test
    void findByCategoryOrName() throws Exception {
        log.info("Testing ProductService.getProductsByCategoryOrName()");

        List<Product> products = productService.findByCategoryOrName(1L, "Test");
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void deleteById() throws Exception {
        log.info("Testing ProductService.deleteById()");

        List<Product> products = productService.getProducts();
        int totalBefore = products.size();

        if (products.isEmpty())
            return;

        Product lastProduct = products.get(products.size() - 1);
        productService.deleteById(lastProduct.getId());

        products = productService.getProducts();
        int totalAfter = products.size();
        assertEquals(1, totalBefore - totalAfter);
    }

    @Test
    void update() throws Exception {
        log.info("Testing ProductService.update()");

        Long id = 22L;
        String ORIGINAL_NAME = "Test";
        String UPDATE_NAME = "Testing...";

        productService.update(id, UPDATE_NAME);

        Product product = productService.findById(id);
        assertEquals(UPDATE_NAME, product.getName());

        productService.update(id, ORIGINAL_NAME);

        product = productService.findById(id);
        assertEquals(ORIGINAL_NAME, product.getName());
    }
}