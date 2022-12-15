package com.example.exbasicspring.discount;

import com.example.exbasicspring.member.domain.Grade;
import com.example.exbasicspring.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 등급은 10% 할인 적용")
    void vip() {
        //given
        Member member = new Member(1L, "gp", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("BASIC 등급은 할인 미적용")
    void basic() {
        //given
        Member member = new Member(1L, "gp", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}