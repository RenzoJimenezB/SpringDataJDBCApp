package pe.edu.tecsup.springbootapp.repositories;

import pe.edu.tecsup.springbootapp.entities.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product) throws Exception;

    List<Product> findAll() throws Exception;

    List<Product> findByName(String name) throws Exception;

    Product findById(Long id) throws Exception;

    void update(Long id, String productName) throws
            Exception;

    void deleteById(Long id) throws Exception;
}
