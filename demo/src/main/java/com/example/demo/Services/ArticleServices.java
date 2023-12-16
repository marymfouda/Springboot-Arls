package com.example.demo.Services;

import com.example.demo.Entity.Articles;
import com.example.demo.Repository.ArticleRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServices {
    private final ArticleRepo arteicalRepo;

    public ArticleServices(ArticleRepo arteicalRepo){
        this.arteicalRepo = arteicalRepo;
    }
    public List<Articles> getAll(){
        return arteicalRepo.findAll();
    }
    public Articles getOne(Long id){
        return arteicalRepo.findById(id).orElseThrow(
                ()-> new IllegalStateException("This Articles with id = " + id + " is not exist")
        );
    }
    public Articles create (Articles articles){
        try{
            return arteicalRepo.save(articles);
        }catch (DataIntegrityViolationException e ){
            throw new RuntimeException("This Product Already Exist");
        }
    }
    public void delete (Long id ){
        arteicalRepo.deleteById(id);
    }
    public Articles update (Long id , Articles articles){
        Articles existArticles = arteicalRepo.findById(id).orElse(null);
        if (existArticles == null){
            throw new RuntimeException("This Articles not Found");
        }
        existArticles.setTitle(articles.getTitle());
        existArticles.setImg_url(articles.getImg_url());
        existArticles.setURL(articles.getURL());
        existArticles.setTitle(articles.getTitle());
        existArticles.setText(articles.getText());

        return arteicalRepo.save(existArticles);
    }
}
