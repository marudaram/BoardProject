package com.eunyoung.boardproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "file")
public class File {

    @Id
    private String file_uuid;

    @Column(length = 100)
    private String file_name;

    @Column(length = 200)
    private String file_path;

    @Column
    private Integer board_num;

    @Column(length = 30, nullable = false)
    private String user_id;

    @Builder
    public File(String file_uuid, String file_name, String file_path, Integer board_num, String user_id) {
        this.file_uuid = file_uuid;
        this.file_name = file_name;
        this.file_path = file_path;
        this.board_num = board_num;
        this.user_id = user_id;
    }
}
