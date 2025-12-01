package com.zorzenon.crud.controllers;
import com.zorzenon.crud.entities.Product;
import com.zorzenon.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()){
            return ResponseEntity.status(404).body("Nenhum produto Encontrado!");
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(productDetails.getName());
        product.setPriceInCents(productDetails.getPriceInCents());

        return productRepository.save(product);
    }

    @DeleteMapping("products/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

}
