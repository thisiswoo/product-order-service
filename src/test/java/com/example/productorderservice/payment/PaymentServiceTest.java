package com.example.productorderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    private PaymentService paymentService;

    private PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        final PaymentGateway paymentGateway = new ConsolePaymentGateway();
        final PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @DisplayName("결제_상품주문")
    @Test
    void 결제_상품주문() throws Exception {
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();

        paymentService.payment(request);
    }

}
