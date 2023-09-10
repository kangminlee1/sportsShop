package project.sportsShop.dto;

import lombok.*;

//얘는 일단 만들어 둔것
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ItemDto {

    private Long id;

    private String itemNm;

    private Integer price;

    private String itemDetail;

    private String imgUrl;
}
