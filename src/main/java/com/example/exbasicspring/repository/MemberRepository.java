package com.example.exbasicspring.repository;

import com.example.exbasicspring.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);

}
