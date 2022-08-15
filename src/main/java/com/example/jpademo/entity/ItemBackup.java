package com.example.jpademo.entity;


import com.example.jpademo.code.ItemType;
import com.example.jpademo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item_backup")
public class ItemBackup extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_backup_id")
    private Long itemBackUpId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name", length = 50)
    private String itemName;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(name = "reason", length = 10)
    private String reason;
}


