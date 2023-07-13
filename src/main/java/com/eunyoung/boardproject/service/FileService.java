package com.eunyoung.boardproject.service;

import com.eunyoung.boardproject.dto.FileRequestDto;
import com.eunyoung.boardproject.dto.FileResponseDto;
import com.eunyoung.boardproject.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public FileResponseDto save(FileRequestDto fileRequestDto) {
        return null;
    }

}
