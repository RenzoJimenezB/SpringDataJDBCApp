package pe.edu.tecsup.springbootapp.services;

import pe.edu.tecsup.springbootapp.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts() throws Exception;
}
