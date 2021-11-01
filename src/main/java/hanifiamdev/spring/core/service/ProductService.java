package hanifiamdev.spring.core.service;

import hanifiamdev.spring.core.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    // @Autowired ini penanda constructor yang digunakan jika mutiple constructor
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
    }
}
