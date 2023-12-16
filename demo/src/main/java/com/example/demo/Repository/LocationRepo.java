package com.example.demo.Repository;

import com.example.demo.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location , Long> {
}
