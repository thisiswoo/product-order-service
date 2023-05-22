package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest {

    @DisplayName("상품등록")
    @Test
    void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();

        // api 요청
        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @DisplayName("상품조회")
    @Test
    void 상품조회() throws Exception {
        // given
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        // when
        final var response = ProductSteps.상품조회요청(productId);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

}
