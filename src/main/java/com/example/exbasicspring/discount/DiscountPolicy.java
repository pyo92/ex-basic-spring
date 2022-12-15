package com.example.exbasicspring.discount;

import com.example.exbasicspring.member.domain.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 금액
     */
    int discount(Member member, int price);

}
