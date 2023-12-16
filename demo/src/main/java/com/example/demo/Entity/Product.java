package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name="Product_sequence",
            sequenceName =  "Product_Sequence" ,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Product_sequence"
    )

    private Long id ;
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
