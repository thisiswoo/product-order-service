# 스프링부트 상품-주문 API 개발로 알아보는 TDD

## 목차
1. [프로잭트 생성]
2. [POJO 상품 등록 기능 구현하기]
3. [스프링부트 테스트로 전환하기]
4. [API 테스트로 전환하기]
5. [JPA 적용하기]

## 설명
- 상품등록 API 요청이 왔을때 메모리가 아니라 DB SQL을 이용하여 저장할 수 있도록 코드 리팩토링

### 문제
- `Srping Boot Application`을 띄우게 되면 `Caching`이 된다.
- 이때, 다른 테스트들에서 상품을 여러 번 `등록/수정/삭제` 할 경우 테스트가 꼬일 수 있다.
- 즉, 격리(독립적이지 않아)가 잘 되지 않아 문제가 발생할 수 있다. 
- [우아한 ATDD]{:target="_blank"}에서 이러한 문제에 대해 자세히 설명해주고 있다.
- 이러한 문제를 해결하려면 테스트 격리를 해줘야 한다. 즉, 테스트 초기화를 해주어야 한다.

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
