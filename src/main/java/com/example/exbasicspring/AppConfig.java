package com.example.exbasicspring;

import com.example.exbasicspring.discount.DiscountPolicy;
import com.example.exbasicspring.discount.FixDiscountPolicy;
import com.example.exbasicspring.discount.RateDiscountPolicy;
import com.example.exbasicspring.member.repository.MemberRepository;
import com.example.exbasicspring.member.repository.MemoryMemberRepository;
import com.example.exbasicspring.member.service.MemberService;
import com.example.exbasicspring.member.service.MemberServiceImpl;
import com.example.exbasicspring.order.service.OrderService;
import com.example.exbasicspring.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
