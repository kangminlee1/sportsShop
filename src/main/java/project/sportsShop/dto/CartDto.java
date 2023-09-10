package project.sportsShop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class CartDto {
    private Long id;
    private String itemNm;
    private String imgUrl;
    private int count; //주문 개수
    private int price;
}
