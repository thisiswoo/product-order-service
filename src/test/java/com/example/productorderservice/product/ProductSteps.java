package com.example.productorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {// RestAssured의 문제점.

    // Srping Boot Application을 띄우게 되면 캐싱이 돼서 다른 테스트들에서 상품을 여러 번 등록하거나 수정하거나 지우거나 될 경우 테스트가 꼬일 수 있다.
    // 즉, 격리가 잘 되지 않아 문제가 발생할 수 있다.
    // 이러한 문제를 해결하기 위해선 테스트 격리를 해야한다. 즉, 테스트 초기화를 해주어야 한다.
    public static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all() // 요청을 보내는 log를 남기는 것
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    public static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }
}