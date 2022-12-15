package com.example.exbasicspring.member.repository;

import com.example.exbasicspring.member.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);

}
