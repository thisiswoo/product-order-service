package com.example.productorderservice.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class DiscountPolicyTest {

    @DisplayName("none_discounted_price")
    @Test
    void none_discounted_price() {
        // given
        final int price = 1000; // 가격이 1,000원 일때

        // when
        final int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);   // 할인정책이 없을 떄(즉, 할인이 없을때)

        // then
        assertThat(discountedPrice).isEqualTo(price);   // 할인정책을 적용한 가격과 price가격은 동일해야한다.
    }

    @DisplayName("fix_1000_discounted_price")
    @Test
    void fix_1000_discounted_price() throws Exception {
        // given
        final int price = 2000; // 가격이 2,000원 일때

        // when
        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);    // 할인정책이 1,000원을 할인해 줄 떄

        // then
        assertThat(discountedPrice).isEqualTo(1000);    // 할인정책을 적용한 가격과 1,000원의 결과가 동일해야한다.
    }

    @DisplayName("over_discounted_price")
    @Test
    void over_discounted_price() throws Exception {
        // given
        final int price = 500; // 가격이 500원 일때

        // when
        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);    // 할인정책이 1,000원을 할인해 줄 떄

        // then
        assertThat(discountedPrice).isEqualTo(0);    // 할인정책을 적용한 가격과 500원의 결과가 동일해야한다. FIX_1000_AMOUNT가 1000원 미
    }
}