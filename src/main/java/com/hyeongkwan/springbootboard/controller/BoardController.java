package com.hyeongkwan.springbootboard.controller;

import com.hyeongkwan.springbootboard.dto.BoardDTO;
import com.hyeongkwan.springbootboard.dto.PageRequestDTO;
import com.hyeongkwan.springbootboard.dto.PageResponseDTO;
import com.hyeongkwan.springbootboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boardList")
    public void boardListFrm(PageRequestDTO pageRequestDTO, Model model) {
        log.info("게시판 리스트 이동");
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        model.addAttribute("dtoList", responseDTO);

    }


}
