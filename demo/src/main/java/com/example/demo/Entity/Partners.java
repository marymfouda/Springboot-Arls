package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
public class Partners {


    @Id
    @SequenceGenerator(
            name="Partners_sequence",
            sequenceName = "Partners_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Partners_sequence"
    )
    private Long id ;
    private String img_url;
    private String name;

    public Partners(Long id, String img_url, String name) {
        this.id = id;
        this.img_url = img_url;
        this.name = name;
    }

    public Partners() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
