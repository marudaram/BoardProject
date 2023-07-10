package com.eunyoung.boardproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer com_num;

    @Column(length = 30, nullable = false)
    private String user_id;

    @Column(length = 30)
    private String com_writer;

    @Column(length = 1000)
    private String com_content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date com_regDate;

    @Column
    private Integer board_num;

    @Builder
    public Comment(Integer com_num, String user_id, String com_writer, String com_content, Date com_regDate, Integer board_num) {
        this.com_num = com_num;
        this.user_id = user_id;
        this.com_writer = com_writer;
        this. com_content = com_content;
        this. com_regDate = com_regDate;
        this. board_num = board_num;
    }

}
