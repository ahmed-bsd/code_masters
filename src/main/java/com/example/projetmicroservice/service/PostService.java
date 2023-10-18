package com.example.projetmicroservice.service;

import com.example.projetmicroservice.entities.Commentaire;
import com.example.projetmicroservice.entities.Post;
import com.example.projetmicroservice.repository.CommentaireRepository;
import com.example.projetmicroservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post findPost(Long idPost) {
        return postRepository.findById(idPost).get();
    }

    public void deletetPost(Long idPost) {
        Post post= postRepository.findById(idPost).get();
        postRepository.delete(post);
    }
}
