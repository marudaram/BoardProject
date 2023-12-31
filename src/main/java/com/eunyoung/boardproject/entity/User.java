package com.eunyoung.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(length = 30, nullable = false)
    private String id;

    @Column(length = 100)
    private String password;

    @Column(length = 10)
    private String name;



}
