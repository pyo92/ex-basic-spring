package com.example.exbasicspring.order.service;

import com.example.exbasicspring.discount.DiscountPolicy;
import com.example.exbasicspring.discount.FixDiscountPolicy;
import com.example.exbasicspring.member.domain.Member;
import com.example.exbasicspring.member.repository.MemberRepository;
import com.example.exbasicspring.member.repository.MemoryMemberRepository;
import com.example.exbasicspring.order.domain.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
