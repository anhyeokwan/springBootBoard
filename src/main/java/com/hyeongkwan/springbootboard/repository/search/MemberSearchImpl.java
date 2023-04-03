package com.hyeongkwan.springbootboard.repository.search;

import com.hyeongkwan.springbootboard.domain.Member;
import com.hyeongkwan.springbootboard.domain.QMember;
import com.hyeongkwan.springbootboard.dto.MemberDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Log4j2
public class MemberSearchImpl extends QuerydslRepositorySupport implements MemberSearch{

    // QuerydslRepositorySupport 상속 시 생성자 필수 생성
    public MemberSearchImpl() {
        super(Member.class);
    }
    @Override
    public Member login(MemberDTO memberDTO) {
        QMember member = QMember.member; // Q도메인 객체
        JPQLQuery<Member> query = from(member); // select ... from member(Q도메인 객체)

        System.out.println("repository 멤버아이디 : " + memberDTO.getMemberId());
        System.out.println("repository 멤버비밀번호 : " + memberDTO.getMemberPw());

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(member.memberId.eq(memberDTO.getMemberId()));
        booleanBuilder.and(member.memberPw.eq(memberDTO.getMemberPw()));

        query.where(booleanBuilder);

        Member mDto = query.fetchOne();

        return mDto;
    }

}
