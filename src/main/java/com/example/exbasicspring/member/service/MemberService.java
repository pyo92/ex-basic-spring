package com.example.exbasicspring.member.service;

import com.example.exbasicspring.member.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long id);

}
