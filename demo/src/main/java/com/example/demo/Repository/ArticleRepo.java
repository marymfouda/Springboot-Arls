package com.example.demo.Repository;

import com.example.demo.Entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Articles , Long> {
}
