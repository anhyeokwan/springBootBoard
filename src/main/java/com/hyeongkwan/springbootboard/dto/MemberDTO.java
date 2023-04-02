package com.hyeongkwan.springbootboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {

    private Long memberNo;
    private String memberId;
    private String memberPw;
    private String memberPhone;
    private String memberEmail;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
