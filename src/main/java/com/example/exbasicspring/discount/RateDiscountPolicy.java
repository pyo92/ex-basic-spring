package com.example.exbasicspring.discount;

import com.example.exbasicspring.member.domain.Grade;
import com.example.exbasicspring.member.domain.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 10; //정률 할인률

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        } else {
            return 0;
        }
    }

}
