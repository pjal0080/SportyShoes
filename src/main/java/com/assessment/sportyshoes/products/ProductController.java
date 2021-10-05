package com.assessment.sportyshoes.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/api/v1/addproduct")
    public void addProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @GetMapping(path = "/api/v1/getproducts")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "api/v1/getproducts/season/{season}")
    public List<Product> getProductsBySeason(@PathVariable String season){
        return productService.getAllProductBySeason(season);
    }


    @GetMapping(path = "api/v1/getproducts/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand){
        return productService.getAllProductByBrand(brand);
    }

    @GetMapping(path = "api/v1/getproducts/color/{color}")
    public List<Product> getProductsByColor(@PathVariable String color){
        return productService.getAllProductByColor(color);
    }

    @GetMapping(path = "api/v1/getproducts/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.getAllProductByCategory(category);
    }

}
