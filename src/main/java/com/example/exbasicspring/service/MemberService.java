package com.example.exbasicspring.service;

import com.example.exbasicspring.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long id);

}
