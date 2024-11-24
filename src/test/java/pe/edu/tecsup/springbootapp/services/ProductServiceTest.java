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

//    @Test
//    void findAll() throws Exception {
//        log.info("Testing ProductService.getProducts()");
//
//        List<Product> products = productService.getProducts();
//        assertNotNull(products);
//        assertFalse(products.isEmpty());
//        assertFalse(products.contains(null));
//
//        products.forEach(product -> System.out.println(product.getName()));
//        products.forEach(System.out::println);
//    }

    @Test
    void getProducts() throws Exception {
        log.info("Testing ProductService.getProducts()");

        List<Product> products = productService.getProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(product -> System.out.println(product.getName()));
        products.forEach(System.out::println);
    }

    @Test
    void findByName() throws Exception {
        log.info("Testing ProductService.getProductsByName()");

        List<Product> products = productService.findByName("Test");
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(product -> System.out.println(product.getName()));
        products.forEach(System.out::println);
    }

    @Test
    void findById() {
    }

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
    void deleteById() {
    }

    @Test
    void update() {
    }
}