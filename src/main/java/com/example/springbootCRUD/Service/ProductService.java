package com.example.springbootCRUD.Service;

import com.example.springbootCRUD.Entity.Product;
import com.example.springbootCRUD.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // Since this ProductService talks with ProductRepository class, so inject ProductRepository in ProductService class using @Autowired.
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public String deleteProductById(int id){
        productRepository.deleteById(id);
        return "product deleted";
    }

    public String deleteProductByName(String name){
        productRepository.deleteByName(name);
        return "product deleted";
    }

    public Product updateProduct(Product product){
        Product existingProduct;

        // Fetching whether product is available in table or not
        existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

}
