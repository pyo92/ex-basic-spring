package com.example.exbasicspring.member.service;

import com.example.exbasicspring.member.domain.Member;
import com.example.exbasicspring.member.repository.MemberRepository;
import com.example.exbasicspring.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    //TODO: OCP, DIP 위배 -> 추후 수정
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

}
