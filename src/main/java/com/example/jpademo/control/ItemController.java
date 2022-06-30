package com.example.jpademo.control;


import com.example.jpademo.dto.ItemDto;
import com.example.jpademo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @PostMapping()
    public List<ItemDto> save(@Valid @RequestBody List<ItemDto> itemDtos) {
        return itemService.saveAll(itemDtos);
    }

    @GetMapping
    public List<ItemDto> getList() {
        return itemService.getList();
    }

    @DeleteMapping("/{itemId}")
    public void delete(@PathVariable Long itemid) {
        itemService.delete(itemid);
    }

}
