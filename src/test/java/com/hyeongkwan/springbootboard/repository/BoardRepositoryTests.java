package com.hyeongkwan.springbootboard.repository;

import com.hyeongkwan.springbootboard.domain.Board;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository; // final 쓰면 안됨

    @Test
    public void insertTest() {
        IntStream.rangeClosed(1, 100).forEach(i -> { // range -> 0~99, rangeCloesed -> 0~100
            Board board = Board.builder()
                    .title("Board Title.." + i)
                    .content("Board content.." + i)
                    .writer("user" + (i < 10 ? ("0" + i) : i))
                    .build();

            boardRepository.save(board);
        });


    }
}
