package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Activity {

    @Id
    @SequenceGenerator(
            name = "Activity_Sequence",
            sequenceName = "Activity_Sequence",
            allocationSize = 1 )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Activity_Sequence"
    )

    private Long id;
    private String text;

    public Activity() {
    }

    public Activity(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
