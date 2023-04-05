package com.hyeongkwan.springbootboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private Long boardNo;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String title;

    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
