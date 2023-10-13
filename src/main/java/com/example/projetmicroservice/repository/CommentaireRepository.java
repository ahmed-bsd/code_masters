package com.example.projetmicroservice.repository;


import com.example.projetmicroservice.entities.Commentaire;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.EnableScheduling;




@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
@EnableEurekaClient
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
