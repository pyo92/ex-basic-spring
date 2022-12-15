package com.example.exbasicspring.order.service;

import com.example.exbasicspring.member.domain.Grade;
import com.example.exbasicspring.member.domain.Member;
import com.example.exbasicspring.member.service.MemberService;
import com.example.exbasicspring.member.service.MemberServiceImpl;
import com.example.exbasicspring.order.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Member member = new Member(1L, "gp", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "item", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}