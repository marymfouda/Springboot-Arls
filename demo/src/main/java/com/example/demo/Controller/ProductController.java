package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/Product")
public class ProductController {
private final ProductService productService;

     public ProductController (ProductService productService){
         this.productService = productService;
     }
    @GetMapping
    public ResponseEntity<?> getAll (){
         try{
             return ResponseEntity.ok().body(productService.getAll());
         }catch (Exception e) {
             return ResponseEntity.ok().body(e.getMessage());
         }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
         try {
             Product product = productService.getOne(id);
             return ResponseEntity.ok().body(product);
         }catch (Exception e){
             return ResponseEntity.status(404).body(e.getMessage());
         }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
         try{
             Product product = productService.getOne(id);
             productService.delete(id);
             return ResponseEntity.ok().body("Product with id = " + id + " deleted Successfully");
         }catch (Exception e){
             return ResponseEntity.status(404).body(e.getMessage());
         }
    }
    @PostMapping
    public ResponseEntity<Product> create (@Validated @RequestBody Product product) {
         Product savedProduct = productService.create(product);
         return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
