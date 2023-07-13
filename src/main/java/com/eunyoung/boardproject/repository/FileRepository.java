package com.eunyoung.boardproject.repository;

import com.eunyoung.boardproject.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, String> {



}
