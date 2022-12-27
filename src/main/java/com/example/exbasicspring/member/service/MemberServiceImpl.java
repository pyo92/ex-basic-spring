package com.example.exbasicspring.member.service;

import com.example.exbasicspring.member.domain.Member;
import com.example.exbasicspring.member.repository.MemberRepository;
import com.example.exbasicspring.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //생성자 주입 방식으로 수정 -> OCP, DIP 만족
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

}
