package com.example.jpademo.dto;

import com.example.jpademo.code.ItemType;
import com.example.jpademo.entity.ItemBackup;
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
public class ItemBackupDto {

    private Long itemBackupId;

    private Long itemId;
    
    @NotBlank(message = "필수입력")
    private String itemName;

    @NotNull(message = "필수입력")
    private ItemType itemType;

    private String reason;

    public ItemBackup toEntity() {
        return ItemBackup.builder()
                .itemId(itemId)
                .itemName(itemName)
                .itemType(itemType)
                .reason(reason)
                .build();
    }

    public static ItemBackupDto of(ItemBackup itemBackup) {
        return ItemBackupDto.builder()
                .itemBackupId(itemBackup.getItemBackUpId())
                .itemId(itemBackup.getItemId())
                .itemName(itemBackup.getItemName())
                .itemType(itemBackup.getItemType())
                .reason(itemBackup.getReason())
                .build();
    }
}
