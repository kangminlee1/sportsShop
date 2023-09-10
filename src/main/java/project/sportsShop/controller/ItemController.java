package project.sportsShop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.sportsShop.dto.ItemFormDto;
import project.sportsShop.entity.Item;
import project.sportsShop.repository.ItemRepository;
import project.sportsShop.service.ItemService;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private  ItemService itemService;


    @GetMapping("/Buy")
    public String Buy(Model model){
        //모든 item가져오기
        List<Item> allItemViewList = itemRepository.findAll();
        System.out.println("adfasdfadffad");
        System.out.println(allItemViewList);
        System.out.println("aldfksalkdflakdf");
        //가져온 item 묶음을 뷰로 전달
        model.addAttribute("item",allItemViewList );
        return "/user/Buy";
    }

    // 상품 상세 get 페이지
    @GetMapping("/{itemId}")
    public String itemDtl(Model model, @PathVariable("itemId") Long itemId){
        Item itemEntity = itemRepository.findById(itemId).orElse(null);
        model.addAttribute("item", itemEntity);
        return "/item/itemDtl";
    }
    // 상품 리스트 get 패이지
    @GetMapping("/item")
    public String showItems(Model model){
        List<Item> ItemList = itemRepository.findAll();
        model.addAttribute("itemList", ItemList);
        return "/item/itemList";
    }

}