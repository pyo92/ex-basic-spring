package com.example.exbasicspring.beanFind;

import com.example.exbasicspring.discount.DiscountPolicy;
import com.example.exbasicspring.discount.FixDiscountPolicy;
import com.example.exbasicspring.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtendsBeanConfig.class);

    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상이면 오류가 발생한다.")
    @Test
    void findBeanByParentDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상이면 빈 이름으로 조회한다.")
    @Test
    void findBeanByParentDuplicateBeanName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("부모 타입으로 모든 하위 빈을 조회한다.")
    @Test
    void findAllExtendsBeanByParent() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class ExtendsBeanConfig {

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }
    }
}
