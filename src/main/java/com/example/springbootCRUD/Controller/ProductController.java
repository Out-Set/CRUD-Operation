package com.example.springbootCRUD.Controller;

import com.example.springbootCRUD.Entity.Product;
import com.example.springbootCRUD.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    // Since this controller talks with ProductService class, so inject ProductService in controller class using @Autowired.
    @Autowired
    private ProductService service;

    // POST APIs
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    // GET APIs
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    // PUT(UPDATE) API
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    // DELETE API
    @DeleteMapping("/deleteById/{id}")
    public String deleteProductById(@PathVariable int id){
        return service.deleteProductById(id);
    }

    @DeleteMapping("/deleteByName/{name}")
    public String deleteProductByName(@PathVariable String name){
        return service.deleteProductByName(name);
    }
}
