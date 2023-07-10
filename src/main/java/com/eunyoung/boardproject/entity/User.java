package com.eunyoung.boardproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(length = 30, nullable = false)
    private String user_id;

    @Column(length = 100)
    private String user_pw;

    @Column(length = 10)
    private String user_name;

    @Builder
    public User(String user_id, String user_pw, String user_name) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
    }

}
