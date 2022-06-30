package com.example.jpademo.service;

import com.example.jpademo.dto.ItemDto;
import com.example.jpademo.entity.Item;
import com.example.jpademo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public List<ItemDto> saveAll(List<ItemDto> itemDtos) {
        List<Item> items = itemDtos.stream().map(itemDto -> itemDto.toEntity()).collect(Collectors.toList());
        return itemRepository.saveAll(items)
                .stream()
                .map(item -> ItemDto.of(item))
                .collect(Collectors.toList());
    }

    public List<ItemDto> getList() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(item -> ItemDto.of(item))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        itemRepository.delete(item);
    }
}
