package com.hyeongkwan.springbootboard.service;

import com.hyeongkwan.springbootboard.domain.Board;
import com.hyeongkwan.springbootboard.dto.BoardDTO;
import com.hyeongkwan.springbootboard.dto.PageRequestDTO;
import com.hyeongkwan.springbootboard.dto.PageResponseDTO;
import com.hyeongkwan.springbootboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        String[] type = pageRequestDTO.getType();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("boardNo"); // 게시판 번호를 기준으로 내림차순

        Page<Board> result = boardRepository.searchAll(type, keyword, pageable);

        List<BoardDTO> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());

        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements()).build();
        // PageResponseDTO 클래스에 builder 어노테이션에 매개변수로 있는 속성들만 ㄱㄱ
    }

}
