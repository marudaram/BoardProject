package com.eunyoung.boardproject.repository;

import com.eunyoung.boardproject.dto.BoardResponseDto;
import com.eunyoung.boardproject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    Page<Board> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update Board b set b.hit=b.hit+1 where b.id=:id")
    void increaseHit(@Param("id") Integer id);


//    Page<Board> findByWriter(@Param("writer") String writer , Pageable pageable);


//    @Modifying
//    @Query(value = "select b from Board b where b.writer=:writer")
//    Page<Board> myBoardCollection(@Param("writer") String writer , Pageable pageable);

//    @Modifying
//    @Query(value = "select b from Board b where b.writer=:writer")
//    List<Board> myBoardList(@Param("writer") String writer);


    List<Board> findByWriter(@Param("writer") String writer);
}
