package com.assessment.sportyshoes.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addNewProduct(Product product){
        productRepository.save(product);
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllProductBySeason(String season){
        return productRepository.findAllBySeason(season);
    }

    public List<Product> getAllProductByBrand(String brand){
        return productRepository.findAllByBrand(brand);
    }

    public List<Product> getAllProductByColor(String color){
        return productRepository.findAllByColor(color);
    }

    public List<Product> getAllProductByCategory(String category){
        return productRepository.findAllByCategory(category);
    }
}
