package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

// 방법 1
// 방법 2) Mockito 로 가장 객체 만들어서 테스트 해보기
@ExtendWith(MockitoExtension.class) // 방법2
class ProductServiceTest {
    private ProductService productService;

    // 방법 1
//    private StubProductPort productPort = new StubProductPort();;
    // 방법 2
    private ProductPort productPort;

    @BeforeEach
    void setUp() {
        // 방법 1
//        productService = new ProductService(productPort);
        // 방법2
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @DisplayName("상품수정")
    @Test
    public void 상품수정() throws Exception {
        // given
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        // 방법 1
//        productPort.getProduct_will_return = product;
        // 방법2
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        // when
        productService.updateProduct(productId, request);

        // then
        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);

    }

    // 방법2를 사용하기 위해선 주석
//    private static class StubProductPort implements ProductPort {
//        public Product getProduct_will_return;
//
//        @Override
//        public void save(final Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(final Long productId) {
//            return getProduct_will_return;
//        }
//    }
}
