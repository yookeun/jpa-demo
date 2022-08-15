package com.example.jpademo.repository;

import com.example.jpademo.code.ItemType;
import com.example.jpademo.entity.Item;
import com.example.jpademo.entity.ItemBackup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemBackupRepository extends JpaRepository<ItemBackup, Long>, ItemRepositoryCustom {
    Item findByItemNameAndItemType(String itemName, ItemType itemType);
}
