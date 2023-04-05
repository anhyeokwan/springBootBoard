package com.hyeongkwan.springbootboard.service;

import com.hyeongkwan.springbootboard.dto.BoardDTO;
import com.hyeongkwan.springbootboard.dto.PageRequestDTO;
import com.hyeongkwan.springbootboard.dto.PageResponseDTO;

public interface BoardService {
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
