package com.example.jpademo.service;

import com.example.jpademo.dto.ItemBackupDto;
import com.example.jpademo.dto.ItemDto;
import com.example.jpademo.entity.Item;
import com.example.jpademo.repository.ItemBackupRepository;
import com.example.jpademo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TxTestService {
    private final ItemRepository itemRepository;
    private final ItemBackupRepository itemBackupRepository;



    public List<ItemDto> saveAll(List<ItemDto> itemDtos) {
        return subSaveAll(itemDtos);
    }

    @Transactional
    public List<ItemDto> subSaveAll(List<ItemDto> itemDtos) {
        List<Item> items = itemDtos.stream().map(ItemDto::toEntity).collect(Collectors.toList());
        items.forEach(item -> itemRepository.save(item));
        return items.stream().map(ItemDto::of).collect(Collectors.toList());

    }

    public List<ItemDto> saveAll2(List<ItemDto> itemDtos) {
        return subSaveAll2(itemDtos);
    }

    //@Transactional
    public List<ItemDto> subSaveAll2(List<ItemDto> itemDtos) {
        List<Item> items = itemDtos.stream().map(ItemDto::toEntity).collect(Collectors.toList());
        return itemRepository.saveAll(items)
                .stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }


    @Transactional
    public ItemDto update(ItemDto itemDto) {
        return subUpdate(itemDto);
    }

    public ItemDto subUpdate(ItemDto itemDto) {
        Item item = itemRepository
                .findById(itemDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 itemID"));
        item.update(itemDto);
        return ItemDto.of(item);
    }

    public ItemDto save(ItemDto itemDto) {
        return ItemDto.of(itemRepository.save(itemDto.toEntity()));
    }


    public ItemDto delete(Long itemId, String reason) {
        return subDelete(itemId, reason);
    }



    @Transactional
    public ItemDto subDelete(Long itemId, String reason) {
        Item item = itemRepository
                .findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 itemID"));

        item.delete();
        itemRepository.save(item);
        saveBackup(item, reason);
        return ItemDto.of(item);
    }

    public void saveBackup(Item item, String reason) {
        ItemBackupDto itemBackDto = ItemBackupDto.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .itemType(item.getItemType())
                .reason(reason)
                .build();
        itemBackupRepository.save(itemBackDto.toEntity());
    }

    @Transactional
    public ItemDto deleteEntity(ItemDto itemDto) {
        Item item = itemRepository.findById(itemDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 itemID"));
        item.delete();

        return ItemDto.of(item);
    }

}
