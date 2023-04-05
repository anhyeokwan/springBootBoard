package com.hyeongkwan.springbootboard.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo; // 게시판 번호

    @Column(length = 100, nullable = false)
    private String title; // 게시판 제목

    @Column(length = 3000, nullable = false)
    private String content; // 게시판 글

    @Column(length = 50, nullable = false)
    private String writer; // 게시판 작성자
}
