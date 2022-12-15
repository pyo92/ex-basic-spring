package com.example.exbasicspring.service;

import com.example.exbasicspring.domain.Grade;
import com.example.exbasicspring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "gp", Grade.VIP);

        //when
        memberService.join(member);
        Member findedMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findedMember);
    }
}