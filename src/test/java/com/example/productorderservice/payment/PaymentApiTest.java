package com.example.productorderservice.payment;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.order.OrderSteps;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentApiTest extends ApiTest {

    @DisplayName("결제_상품주문")
    @Test
    void 결제_상품주문() throws Exception {
        // given
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final var request = PaymentSteps.주문결제요청_생성();

        // when
        final var response = PaymentSteps.주문결제요청(request);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
