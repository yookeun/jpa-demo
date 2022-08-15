package com.example.jpademo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 1944448829L;

    public static final QItem item = new QItem("item");

    public final com.example.jpademo.entity.common.QBaseEntity _super = new com.example.jpademo.entity.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final StringPath deleteYn = createString("deleteYn");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final StringPath itemName = createString("itemName");

    public final EnumPath<com.example.jpademo.code.ItemType> itemType = createEnum("itemType", com.example.jpademo.code.ItemType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

