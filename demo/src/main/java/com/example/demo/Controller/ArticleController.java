package com.example.demo.Controller;

import com.example.demo.Entity.Articles;
import com.example.demo.Services.ArticleServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Articles")
public class ArticleController {

    private final ArticleServices articleServices;

    public ArticleController(ArticleServices articleServices){
        this.articleServices =articleServices;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(articleServices.getAll());
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            Articles articles = articleServices.getOne(id);
            return ResponseEntity.ok().body(articles);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Articles articles = articleServices.getOne(id);
            articleServices.delete(id);
            return ResponseEntity.ok().body("Articles with id = " + id + " deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Articles> create (@Validated @RequestBody Articles articles) {
        Articles savedArticles = articleServices.create(articles);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticles);
    }

}
