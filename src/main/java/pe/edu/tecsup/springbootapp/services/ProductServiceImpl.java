package pe.edu.tecsup.springbootapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.springbootapp.entities.Product;
import pe.edu.tecsup.springbootapp.repositories.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) throws Exception {
        log.info("ProductServiceImpl.save()");

        productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() throws Exception {
        log.info("ProductServiceImpl.getProducts()");

        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) throws Exception {
        log.info("ProductServiceImpl.findByName()");

        return productRepository.findByName(name);
    }

    @Override
    public Product findById(Long id) throws Exception {
        log.info("ProductServiceImpl.findById()");

        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByCategoryOrName(Long categoryId, String code) throws Exception {
        log.info("ProductServiceImpl.findByCategoryOrName()");

        return productRepository.findByCategoryOrName(categoryId, code);
    }

    @Override
    public void update(Long id, String productName) throws Exception {
        log.info("ProductServiceImpl.update()");

        productRepository.update(id, productName);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        log.info("ProductServiceImpl.deleteById()");

        productRepository.deleteById(id);
    }
}
