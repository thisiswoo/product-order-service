package com.example.productorderservice.product;

public enum DiscountPolicy {

    // 할인 받지 않는 정책
    NONE {
        @Override
        int applyDiscount(final int price) {
            return price;
        }
    },
    FIX_1000_AMOUNT {
        @Override
        int applyDiscount(final int price) {
            return Math.max(price - 1000, 0);
        }
    };

    abstract int applyDiscount(final int price);
}
