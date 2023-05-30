package com.example.productorderservice.order;

import com.example.productorderservice.product.DiscountPolicy;
import com.example.productorderservice.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @DisplayName("getTotalPrice")
    @Test
    void getTotalPrice() throws Exception {
        // given
//        final Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        // when
        final int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(2000);
    }
}