package com.eunyoung.boardproject.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_num; // pk -> auto_increment

    @Column(length = 30, nullable = false)
    private String user_id;

    @Column(length = 210)
    private String board_title;

    @Column(columnDefinition = "TEXT") //type을 text로 바꿔준다
    private String board_content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date board_regDate;

    @Column
    private Integer board_hit;

    @Builder
    public Board(Integer board_num, String user_id, String board_title, String board_content, Date board_regDate, Integer board_hit) {
        this.board_num = board_num;
        this.user_id = user_id;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_regDate = board_regDate;
        this.board_hit = board_hit;
    }

}
