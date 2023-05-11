package com.example.productorderservice;

import com.google.common.base.CaseFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DatabaseCleanup implements InitializingBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Override
    public void afterPropertiesSet() {
        // entityManager에서 entity들을 모두 가져온다
        final Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // entity가 stream()을 돌면서
        tableNames = entities.stream()
                .filter(e -> isEntity(e) && hasTableAnnotation(e))  // 전체 엔티티에서 @Entity와 @Table이 있는지 확인 후
                .map(e -> e.getJavaType().getAnnotation(Table.class).name()) // 위 @Table 들의 name을 전부 가져오고
                .collect(Collectors.toList());  // list에 담는다

        final List<String> entityNames = entities.stream()
                .filter(e -> isEntity(e) && !hasTableAnnotation(e)) // @Entity가 붙어있으면서 @Table 어노테이션이 없는 것들만 찾아와
                // Camel Case로 된 (ex) ProductItem -> product_item)으로 바꿔주는 Google에 guava 라이브러리
                .map(e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, e.getName()))
                .toList();

        tableNames.addAll(entityNames);
    }

    /**
     * @Entity라는 어노테이션이 확인
     *
     * @param e
     * @return boolean
     */
    private boolean isEntity(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Entity.class);
    }

    /**
     * @Table이라는 어노테이션이 있는지 확인
     *
     * @param e
     * @return boolean
     */
    private boolean hasTableAnnotation(final EntityType<?> e) {
        return null != e.getJavaType().getAnnotation(Table.class);
    }


    /**
     * 초기화 메서드
     *
     * REFERENTIAL_INTEGRITY 이란?
     * - Relational database에서 Referential integrity는 테이블간의 관계가 항상 consistent하게 유지되어야 한다는 개념
     * - 즉, 테이블이 Primary key와 Foreign key로 연결되는 관계를 가질 때, 어떤 foreign key던지 항상 연결되어 있는 다른 테이블의 primary key(즉, 레퍼런스)가 제대로 존재해야 한다는 뜻
     * - 따라서 업데이트나 삭제가 일어나도 연결된 두테이블이 항상 synchronized 되게 해주는 법칙입니다.
     *
     * DELETE vs TRUNCATE vs DROP 란?
     * - DELETE : 데이터는 지워지지만 테이블 용량은 줄어 들지 않는다. 원하는 데이터만 지울 수 있다. 삭제 후 잘못 삭제한 것을 되돌릴 수 있다.
     * TRUNCATE : 용량이 줄어 들고, 인덱스 등도 모두 삭제 된다. 테이블은 삭제하지는 않고, 데이터만 삭제한다. 한꺼번에 다 지워야 한다. 삭제 후 절대 되돌릴 수 없다.
     * DROP : 데이블 전체를 삭제, 공간, 객체를 삭제한다. 삭제 후 절대 되돌릴 수 없다.
     */
    @Transactional
    public void execute() {
        entityManager.flush();
        // foreign key가 설정 되어있으면 삭제할 때 FK로 지정되어있어 쉽게 삭제가 어려운데, 그것을 false로 하여 무시하는 설정
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        for (final String tableName : tableNames) {
            // 위에서 정의한 table들을 TRUNCATE하여 row 값들을 모두 지운다음에
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            // @GeneratedValue(strategy = GenerationType.IDENTITY)의 값을 1로 초기화 한다.
            entityManager.createNativeQuery("ALTER TABLE " + tableName + " ALTER COLUMN ID RESTART WITH 1").executeUpdate();
        }

        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }
}
