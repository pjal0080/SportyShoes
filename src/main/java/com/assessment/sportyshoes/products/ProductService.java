package com.assessment.sportyshoes.products;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Product> getAllProductByCategory(String category){return productRepository.findAllByCategory(category);}

    public void deleteProductById(Long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("product with id %s not found",id)));
        productRepository.delete(product);
    }


    public void updateProductById(Long id, Product newProduct) throws NotFoundException {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("product with id %s not found",id)));

        product.setProductName(newProduct.getProductName());
        product.setProductBrand(newProduct.getProductBrand());
        product.setProductColor(newProduct.getProductColor());
        product.setDiscount(newProduct.getDiscount());
        product.setPrice(newProduct.getPrice());
        product.setProductCategory(newProduct.getProductCategory());
        product.setProductSeason(newProduct.getProductSeason());
        product.setQuantity(newProduct.getQuantity());

        productRepository.save(product);

    }

    public Optional<Product> getProductById(Long id) {

        return productRepository.findById(id);
    }
}
