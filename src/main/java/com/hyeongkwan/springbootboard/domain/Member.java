package com.hyeongkwan.springbootboard.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor // 매개변수 있는 생성자
@ToString
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo; // 회원번호

    @Column(length = 50, nullable = false)
    private String memberId; // 회원아이디

    @Column(length = 100, nullable = false)
    private String memberPw; // 회원 비밀번호

    @Column(length = 13, nullable = false)
    private String memberPhone; // 회원 전화번호

    @Column(length = 50, nullable = true)
    private String memberEmail; // 회원 이메일



}
