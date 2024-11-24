package pe.edu.tecsup.springbootapp.repositories;

import pe.edu.tecsup.springbootapp.entities.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll() throws Exception;
}
