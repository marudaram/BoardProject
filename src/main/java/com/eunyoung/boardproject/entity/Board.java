package com.eunyoung.boardproject.entity;

import lombok.*;

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
    private int id; // pk -> auto_increment

    @Column(length = 30, nullable = false)
    private String writer;

    @Column(length = 210)
    private String title;

    @Lob
//    @Column(columnDefinition = "TEXT") //type을 text로 바꿔준다
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    private Integer hit;

    /**
     * 게시글 내용 변경
     *
     * @param title   -- 변경할 제목
     * @param content -- 변경할 내용
     */
    public void changeBoard(String title, String content) {
        this.title = title;
        this.content = content;
        this.regDate = new Date();
    }

    public int increaseHit() {
        return this.hit++;
    }

}
