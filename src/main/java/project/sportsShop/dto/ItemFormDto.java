package project.sportsShop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import project.sportsShop.entity.Item;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ItemFormDto {

    private Long id;

    private String itemNm;

    private Integer price;

    private String itemUrl;

    private int stockNumber;

    private String itemDetail;

    private List<ItemFormDto> itemDtoList = new ArrayList<>();

    public Item toEntity() {
        return new Item(id,itemNm,price,itemUrl, stockNumber, itemDetail);
    }

}
