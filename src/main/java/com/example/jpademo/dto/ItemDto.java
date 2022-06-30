package com.example.jpademo.dto;

import com.example.jpademo.code.ItemType;
import com.example.jpademo.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long itemId;
    
    @NotBlank(message = "필수입력")
    private String itemName;

    @NotNull(message = "필수입력")
    private ItemType itemType;

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .itemType(itemType)
                .build();
    }

    public static ItemDto of(Item item) {
        return ItemDto.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .itemType(item.getItemType())
                .build();
    }
}
