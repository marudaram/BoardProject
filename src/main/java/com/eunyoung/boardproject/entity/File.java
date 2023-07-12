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
@Table(name = "file")
public class File {

    @Id
    private String id;

    @Column(length = 100)
    private String name;

    @Column(length = 200)
    private String path;

    @Column
    private Integer boardId;

    @Column(length = 30, nullable = false)
    private String uploader;

}
