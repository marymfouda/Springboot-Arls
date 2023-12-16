package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Articles {

    @Id
    @SequenceGenerator(
            name="articles_sequence",
            sequenceName = "articles_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "articles_sequence"
    )
    private Long id ;
    private String URL;
    private String img_url;
    private String title;
    private String text;

    public Articles() {
    }

    public Articles(Long id, String URL, String img_url, String title, String text) {
        this.id = id;
        this.URL = URL;
        this.img_url = img_url;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
