package com.example.exbasicspring;

import com.example.exbasicspring.member.domain.Grade;
import com.example.exbasicspring.member.domain.Member;
import com.example.exbasicspring.member.service.MemberService;
import com.example.exbasicspring.order.domain.Order;
import com.example.exbasicspring.order.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "gp", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "item", 20000);
        System.out.println("order = " + order);
    }

}
