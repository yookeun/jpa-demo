package com.example.jpademo.entity;


import com.example.jpademo.code.ItemType;
import com.example.jpademo.dto.ItemDto;
import com.example.jpademo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item")
@ToString
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name",length = 50)
    private String itemName;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(name = "deleteYn", length = 1)
    @Builder.Default
    private String deleteYn = "N";

    public void update(ItemDto itemDto) {
        this.itemName = itemDto.getItemName();
        this.itemType = itemDto.getItemType();
    }

    public void delete() {
        this.deleteYn = "Y";
    }
}
