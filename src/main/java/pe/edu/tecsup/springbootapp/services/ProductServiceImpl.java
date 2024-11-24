package pe.edu.tecsup.springbootapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.springbootapp.entities.Product;
import pe.edu.tecsup.springbootapp.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() throws Exception {
        log.info("ProductServiceImpl.getProducts()");

        return productRepository.findAll();
    }
}
