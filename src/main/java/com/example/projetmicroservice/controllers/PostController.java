package com.example.projetmicroservice.controllers;


import com.example.projetmicroservice.entities.Commentaire;
import com.example.projetmicroservice.entities.Post;
import com.example.projetmicroservice.service.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "post")
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/add")
    @ResponseBody
    public Post ajouterCommentaire(@RequestBody Post post) {

        return postService.createPost(post);
    }
    @GetMapping("/all/post")
    @ResponseBody
    public List<Post> getpost(){
        return  postService.getAllPost();
    }
    @DeleteMapping("/delete/post/{id}")
    public void deletePost(@PathVariable("id") Long idPost) {
        postService.deletetPost(idPost);
    }
    @GetMapping("/find/post/{id}")
    public Post findPost(@PathVariable("id") Long idPost) {
        return postService.findPost(idPost);
    }
}
