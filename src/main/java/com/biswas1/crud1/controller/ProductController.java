package com.biswas1.crud1.controller;

import com.biswas1.crud1.entity.Product;
import com.biswas1.crud1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody  Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/product")
    public List<Product> findProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteById(id);
    }
}

