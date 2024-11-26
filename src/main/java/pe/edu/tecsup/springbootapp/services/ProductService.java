package pe.edu.tecsup.springbootapp.services;

import pe.edu.tecsup.springbootapp.entities.Product;

import java.util.List;

public interface ProductService {
    void save(Product product) throws Exception;

    List<Product> getProducts() throws Exception;

    List<Product> findByName(String name) throws Exception;

    Product findById(Long id) throws Exception;

    List<Product> findByCategoryOrName(Long categoryId, String code) throws Exception;

    void deleteById(Long id) throws Exception;

    void update(Long id, String productName) throws Exception;
}
