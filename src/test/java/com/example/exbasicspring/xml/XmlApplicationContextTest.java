package com.example.exbasicspring.xml;

import com.example.exbasicspring.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

class XmlApplicationContextTest {

    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    void xmlAppContext() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
