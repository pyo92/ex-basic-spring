package com.example.exbasicspring.discount;

import com.example.exbasicspring.member.domain.Grade;
import com.example.exbasicspring.member.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountAmount = 1000; //정액 할인 금액

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        } else {
            return 0;
        }
    }

}
