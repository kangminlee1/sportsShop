package project.sportsShop.entity;

import lombok.*;
import project.sportsShop.dto.ItemFormDto;
import project.sportsShop.exception.OutOfStockException;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
@ToString
@Getter
public class Item{
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @Column()
    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명
    //    @Column(name="price")
    @Column(name="price", nullable = false)
    private int price;
    //    @Column
    @Column
    private String imgUrl; // 이미지
    //    @Column
    @Column(nullable = false)
    private int stockNumber; // 재고수량
    @Lob
    @Column(nullable = false)
    //    @Column
    private String itemDetail; // 상품 상세 설명


    // 상품 데이터를 업데이트 하는 로직 생성
    public void updateItem(ItemFormDto itemFormDto){ //
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
    }
//    /*
//    엔티티 클래스에 비즈니스 로직을 추가하면 객체지향적으로 코딩을 할 수 있고, 코드를 재활용 할 수도 있다.
//    데이터 변경 포인트를 여기로 지정할 수 있움(데이터 수정 변경 여기서만 한다는 뜻)
//    엔티티 클래스에 비즈니스 로직(데이터 처리) 을 추가하면
//    1. 객체지향적으로 코딩을 할 수 있고,
//    2. 코드를 재활용 할 수도 있다.
//    3. 데이터 변경 포인트를 여기로 지정할 수 있움(데이터 수정 변경 여기서만 한다는 뜻)
//     */
//
//    // 상품 주문 -> 상품 재고 감소 로직 생성
//    public void removeStock(int stockNumber){
//
//        int restStock = this.stockNumber - stockNumber; // stockNumber: 상품의 재고 수량 restStock: 주문 후 남은 재고 수량
//
//        if(restStock<0){ // 상품 재고가 주문 수량보다 작을 경우, 재고 부족 예외 발생
//            throw new OutOfStockException("상품의 재고가 부족 합니다. (현재 재고 수량: " + this.stockNumber + ")");
//        }
//        this.stockNumber = restStock; // 주문 후 남은 재고 수량 = 상품의 현재 재고 값
//    }
//
//    // 주문 취소 시 상품 개수 늘림
//    public void addStock(int stockNumber){
//        this.stockNumber += stockNumber;
//    }

}
