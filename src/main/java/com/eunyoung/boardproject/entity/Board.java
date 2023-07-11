package com.eunyoung.boardproject.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_num; // pk -> auto_increment

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

    public void changeBoard(String title, String content) {
        this.board_title = title;
        this.board_content = content;
    }

}
