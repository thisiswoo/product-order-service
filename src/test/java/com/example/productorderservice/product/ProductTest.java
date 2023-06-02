package com.example.productorderservice.product;

import com.example.productorderservice.product.domain.DiscountPolicy;
import com.example.productorderservice.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    @DisplayName("업데이트_테스트")
    @Test
    void 업데이트_테스트() throws Exception {
        // given
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        // when
        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        // then
        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @DisplayName("none_discounted_product")
    @Test
    void none_discounted_product() throws Exception {
        // given
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        // when
        final int discountPrice = product.getDiscountedPrice();

        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @DisplayName("fix_1000_discounted_product")
    @Test
    void fix_1000_discounted_product() throws Exception {
        // given
        final Product product = new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);

        // when
        final int discountPrice = product.getDiscountedPrice();

        // then
        assertThat(discountPrice).isEqualTo(0);
    }
}
