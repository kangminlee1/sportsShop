package project.sportsShop.service;

// 상품 등록

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.sportsShop.dto.MainItemDto;
import project.sportsShop.entity.Item;
import project.sportsShop.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

// 상품 등록 service
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    @Autowired
    private final ItemRepository itemRepository;


    public List<Item> index(){
        return itemRepository.findAll();
    }
    public Item show(Long itemId){
        return itemRepository.findById(itemId).orElse(null);
    }

}
