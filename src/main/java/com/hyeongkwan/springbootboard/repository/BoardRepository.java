package com.hyeongkwan.springbootboard.repository;

import com.hyeongkwan.springbootboard.domain.Board;
import com.hyeongkwan.springbootboard.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
}
