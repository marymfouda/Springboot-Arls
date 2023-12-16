package com.example.demo.Services;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService (ProductRepo productRepo){
        this.productRepo = productRepo ;
    }
    public List<Product> getAll(){
        return productRepo.findAll();
    }
    public Product getOne(Long id){

        return productRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("This Product with id = " + id + " is not exist"));
    }

    public Product create (Product product){
        try{
            return productRepo.save(product);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("This Product Already Exist");
        }
    }
    public void delete(Long id){
        productRepo.deleteById(id);
    }
    public Product update(Long id, Product product) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct == null) {
            throw new RuntimeException("Product not found");
        }

        existingProduct.setName(product.getName());


        return productRepo.save(existingProduct);
    }
}
