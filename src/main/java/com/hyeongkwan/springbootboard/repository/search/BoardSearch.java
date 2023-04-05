package com.hyeongkwan.springbootboard.repository.search;

import com.hyeongkwan.springbootboard.domain.Board;
import com.hyeongkwan.springbootboard.dto.BoardDTO;
import com.hyeongkwan.springbootboard.dto.PageRequestDTO;
import com.hyeongkwan.springbootboard.dto.PageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> searchAll(String[] type, String keyword, Pageable pageable);
}
