package com.hyeongkwan.springbootboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1; // 현재페이지

    @Builder.Default
    private int size = 10; // 페이지네비게이션 사이즈

    private String type; // 검색의 종류

    private String keyword; // 검색어

    public String[] getTypes(){ // 검색 타입 구분
        if (type == null || type.isEmpty()) {
            return null;
        }

        return type.split("");
    }

    public Pageable getPageable(String...prop) {
        return PageRequest.of(this.page - 1, this.size, Sort.by(prop).descending()); // 내림차순
    }

    private String link;

    public String getLink() { // 링크
        if (link == null) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("page=" + this.page);
            stringBuilder.append("&size=" + this.size);

            if (type != null && type.length() > 0) {
                stringBuilder.append("type=" + this.type);
            }

            if (keyword != null) {
                try {
                    stringBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
            }

            link = stringBuilder.toString();
        }

        return link;
    }
}
















