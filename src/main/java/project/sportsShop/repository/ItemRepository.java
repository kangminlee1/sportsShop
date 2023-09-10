package project.sportsShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.sportsShop.entity.Item;

import java.util.ArrayList;
import java.util.List;
/*
 * Querydsl 을 SpringDataJpa 와 함께 사용하기 위해서는 사용자 정의 repository 를 작성해야 함
 * 사용자 정의 repository 는 총 3단계임
 * 1. 사용자 정의 인터페이스 작성
 * 2. 사용자 정의 인터페이스 구현
 * 3. Spring Data Jpa repository 에서 사용자 정의 인터페이스 상속 ** (ItemRepository)
 * */

// 3. ItemRepository 에서 ItemRepositoryCustom 상속
public interface ItemRepository extends JpaRepository<Item,Long>{

        // 쿼리 메소드: find + (엔티티이름) + By+ 변수이름
        // 조건 하나 추가할 때 마다 By 를 넣어줘야 한다!!!
        /*
         * 쿼리 메소드는 조건이 많아지면
         * 쿼리 메소드의 이름을 보고 어떻게 동작하는지 해석하기 어렵다.
         * */

//        // 상품명으로 데이터 조회하기
//        List<Item> findByItemNm(String itemNm);
//
//        // or 조건
//        List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
//
//        // lessThan 조건
//        List<Item> findByPriceLessThan(Integer price);
//
//        // orderBy 조건
//        List<Item> findAllByOrderByPriceDesc();
//
//        // orderBy 조건 + 가격 조건
//        List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

        //전체
        @Override
        ArrayList<Item> findAll();
}