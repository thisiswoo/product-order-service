# 스프링부트 상품-주문 API 개발로 알아보는 TDD

## 목차
1. [프로잭트 생성]
2. [POJO 상품 등록 기능 구현하기]
3. [스프링부트 테스트로 전환하기]
4. [API 테스트로 전환하기]
5. [JPA 적용하기]
6. [상품 조회 기능 구현하기]
7. [상품조회 기능 API 테스트로 전환하기]
8. [POJO 상품 수정 기능 구현하기]
9. [POJO 상품 수정 기능 스프링부트 테스트로 전환하기]
10. [스프링부트 API 테스트로 전환하기]
11. [POJO 상품 주문 기능 구현하기]
12. [스프링부트 테스트로 전환하기]
13. [API 테스트로 전환하기]
14. [API로 만든 상품 주문을 JPA로 적용하기]
15. [POJO 주문 결제 기능 구현하기]
16. [주문결제 스프링부트 테스트로 전환하기]
17. [주문결제 API 테스트로 전환하기]
18. [주문결제 JPA 적용하기]
19. [상세 패키지 구조 만들기]

## 설명
- 상품 주문 등록 서비스의 패키지 세분화하여 나누기.

## 프로젝트
- `Java` : `17.0.5 LTS`
- `IntelliJ` : `2023.1`

<!-- Links -->
[프로잭트 생성]: https://github.com/thisiswoo/product-order-service/tree/1.%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EC%83%9D%EC%84%B1
[POJO 상품 등록 기능 구현하기]: https://github.com/thisiswoo/product-order-service/tree/2.POJO_%EC%83%81%ED%92%88%EB%93%B1%EB%A1%9D_%EA%B8%B0%EB%8A%A5_%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
[스프링부트 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/3.%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[API 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/4.API_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[우아한 ATDD]: https://www.youtube.com/watch?v=ITVpmjM4mUE&t=270
[JPA 적용하기]: https://github.com/thisiswoo/product-order-service/tree/5.JPA_%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0 
[상품 조회 기능 구현하기]: https://github.com/thisiswoo/product-order-service/tree/6.%EC%83%81%ED%92%88%EC%A1%B0%ED%9A%8C_%EA%B8%B0%EB%8A%A5_%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
[상품조회 기능 API 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/7.%EC%83%81%ED%92%88%EC%A1%B0%ED%9A%8C_%EA%B8%B0%EB%8A%A5%EC%9D%84_API_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[POJO 상품 수정 기능 구현하기]: https://github.com/thisiswoo/product-order-service/tree/8.POJO_%EC%83%81%ED%92%88_%EC%88%98%EC%A0%95_%EA%B8%B0%EB%8A%A5_%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
[POJO 상품 수정 기능 스프링부트 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/9.POJO%EC%83%81%ED%92%88%EC%88%98%EC%A0%95%EA%B8%B0%EB%8A%A5_%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[스프링부트 API 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/10.%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8_API_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[POJO 상품 주문 기능 구현하기]: https://github.com/thisiswoo/product-order-service/tree/11.POJO_%EC%83%81%ED%92%88_%EC%A3%BC%EB%AC%B8_%EA%B8%B0%EB%8A%A5_%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
[스프링부트 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/12.%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[API 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/13.API_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[API로 만든 상품 주문을 JPA로 적용하기]: https://github.com/thisiswoo/product-order-service/tree/14.API%EB%A1%9C_%EB%A7%8C%EB%93%A0_%EC%83%81%ED%92%88_%EC%A3%BC%EB%AC%B8%EC%9D%84_JPA%EB%A1%9C_%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
[POJO 주문 결제 기능 구현하기]: https://github.com/thisiswoo/product-order-service/tree/15.POJO_%EC%A3%BC%EB%AC%B8_%EA%B2%B0%EC%A0%9C_%EA%B8%B0%EB%8A%A5_%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
[주문결제 스프링부트 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/16.%EC%A3%BC%EB%AC%B8%EA%B2%B0%EC%A0%9C_%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[주문결제 API 테스트로 전환하기]: https://github.com/thisiswoo/product-order-service/tree/17.%EC%A3%BC%EB%AC%B8%EA%B2%B0%EC%A0%9C_API_%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A1%9C_%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0
[주문결제 JPA 적용하기]: https://github.com/thisiswoo/product-order-service/tree/18.%EC%A3%BC%EB%AC%B8%EA%B2%B0%EC%A0%9C_JPA_%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
[상세 패키지 구조 만들기]: https://github.com/thisiswoo/product-order-service/tree/19.%EC%83%81%EC%84%B8_%ED%8C%A8%ED%82%A4%EC%A7%80_%EA%B5%AC%EC%A1%B0_%EB%A7%8C%EB%93%A4%EA%B8%B0