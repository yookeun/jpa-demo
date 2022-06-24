package com.example.jpademo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyBook is a Querydsl query type for MyBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyBook extends EntityPathBase<MyBook> {

    private static final long serialVersionUID = 422647903L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyBook myBook = new QMyBook("myBook");

    public final com.example.jpademo.entity.common.QBaseEntity _super = new com.example.jpademo.entity.common.QBaseEntity(this);

    public final QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final QMember member;

    public final NumberPath<Long> mybookId = createNumber("mybookId", Long.class);

    public final EnumPath<com.example.jpademo.code.ReadState> readState = createEnum("readState", com.example.jpademo.code.ReadState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QMyBook(String variable) {
        this(MyBook.class, forVariable(variable), INITS);
    }

    public QMyBook(Path<? extends MyBook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyBook(PathMetadata metadata, PathInits inits) {
        this(MyBook.class, metadata, inits);
    }

    public QMyBook(Class<? extends MyBook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new QBook(forProperty("book"), inits.get("book")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

