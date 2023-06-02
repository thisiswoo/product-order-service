package com.example.productorderservice.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "주문 ID는 필수입니다.");
        Assert.hasText(cardNumber, "카드번호는 필수 입니다.");
    }
}
