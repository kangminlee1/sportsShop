package project.sportsShop.controller;

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
public class MainController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private  ItemService itemService;

    @GetMapping("/")
    public String main(Model model){
        List<Item> ItemList = itemRepository.findAll();
        model.addAttribute("itemList", ItemList);
        return "/main";
    }
}
