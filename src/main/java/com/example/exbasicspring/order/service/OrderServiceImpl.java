package com.example.exbasicspring.order.service;

import com.example.exbasicspring.discount.DiscountPolicy;
import com.example.exbasicspring.discount.FixDiscountPolicy;
import com.example.exbasicspring.member.domain.Member;
import com.example.exbasicspring.member.repository.MemberRepository;
import com.example.exbasicspring.member.repository.MemoryMemberRepository;
import com.example.exbasicspring.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

    @Autowired
    //생성자 주입 방식으로 수정 -> OCP, DIP 만족
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
