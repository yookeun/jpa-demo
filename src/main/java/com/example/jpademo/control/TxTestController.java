package com.example.jpademo.control;

import com.example.jpademo.dto.ItemDto;
import com.example.jpademo.service.TxTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TxTestController {

    private final TxTestService txTestService;

    @PostMapping("/item")
    public ItemDto save(@Valid @RequestBody ItemDto itemDto) {
        return txTestService.save(itemDto);
    }


    @PostMapping("/items")
    public List<ItemDto> saveAll(@Valid @RequestBody List<ItemDto> itemDtos) {
        return txTestService.saveAll(itemDtos);
    }


    @PostMapping("/items2")
    public List<ItemDto> saveAll2(@Valid @RequestBody List<ItemDto> itemDtos) {
        return txTestService.saveAll2(itemDtos);
    }

    @PutMapping("/items/{id}")
    public ItemDto update(@PathVariable Long id, @Valid @RequestBody ItemDto itemDto) {
        itemDto.setItemId(id);
        return txTestService.update(itemDto);
    }

    @DeleteMapping("/items")
    public ItemDto delete(@RequestBody ItemDto itemDto) {
        return txTestService.deleteEntity(itemDto);
    }

}
