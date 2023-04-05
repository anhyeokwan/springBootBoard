package com.hyeongkwan.springbootboard.repository.search;

import com.hyeongkwan.springbootboard.domain.Board;
import com.hyeongkwan.springbootboard.domain.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.hibernate.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl(){super(Board.class);}

    @Override
    public Page<Board> searchAll(String[] type, String keyword, Pageable pageable) {
        QBoard board = QBoard.board; // QBoard 도메인 생성
        JPQLQuery<Board> query = from(board); // select ... from board

        log.info("보드서치임플 : " + Arrays.toString(type) + ", " + keyword);

        if ((type.length > 0 && type != null) && !keyword.equals("")) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for (String types : type) {
                switch (types) {
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;

                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;

                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }

            query.where(booleanBuilder);
        }else {
            query.where(board.boardNo.gt(0L));
        }

        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> dtoList = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(dtoList, pageable, count); // 리스트(내용), pageable, total(게시물 총 개수)
    }
}















