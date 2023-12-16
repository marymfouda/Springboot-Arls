package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Contacts {
    @Id
    @SequenceGenerator(
            name="Contacts_sequence",
            sequenceName = "Contacts_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Contacts_sequence"
    )

    private Long id ;
    private String Phone_number;
    private String email;

    public Contacts() {
    }

    public Contacts(Long id, String phone_number, String email) {
        this.id = id;
        Phone_number = phone_number;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
