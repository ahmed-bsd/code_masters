package com.example.immoprojectmicroservice.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class TokenResetpwd implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private Boolean expired;

    @OneToOne
    private UserA userA;

    public TokenResetpwd(String token, UserA userA) {
        this.token = token;
        this.expired = false;
        this.userA = userA;
    }
}
