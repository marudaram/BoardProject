package com.eunyoung.boardproject.repository;

import com.eunyoung.boardproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
