package com.assessment.sportyshoes.admin;

import com.assessment.sportyshoes.orders.Order;
import com.assessment.sportyshoes.orders.OrderService;
import com.assessment.sportyshoes.products.Product;
import com.assessment.sportyshoes.products.ProductService;
import com.assessment.sportyshoes.users.User;
import com.assessment.sportyshoes.users.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    @Autowired
    public AdminController(UserService userService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }


    @GetMapping(path = "/getusers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/getorders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }


    @PostMapping(path = "/addproduct")
    public void addProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @GetMapping(path = "/getproducts")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/getproducts/season/{season}")
    public List<Product> getProductsBySeason(@PathVariable String season){
        return productService.getAllProductBySeason(season);
    }


    @GetMapping(path = "/getproducts/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand){
        return productService.getAllProductByBrand(brand);
    }

    @GetMapping(path = "/getproducts/color/{color}")
    public List<Product> getProductsByColor(@PathVariable String color){
        return productService.getAllProductByColor(color);
    }

    @GetMapping(path = "/getproducts/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.getAllProductByCategory(category);
    }

    @DeleteMapping(path = "/deleteproduct/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProductById(id);

    }

    @PutMapping("/updateproduct/{id}")
    public void updateProduct(@PathVariable Long id,
                              @RequestBody Product product)
            throws NotFoundException {
        productService.updateProductById(id,product);

    }


}
