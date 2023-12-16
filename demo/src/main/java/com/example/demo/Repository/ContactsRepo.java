package com.example.demo.Repository;

import com.example.demo.Entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepo extends JpaRepository<Contacts , Long> {
}
