package com.example.shirojwt.controller;

import com.example.shirojwt.dto.ArticleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public ResponseEntity<List<ArticleDto>> list(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> read(@PathVariable Long id){
        return null;
    }


}
