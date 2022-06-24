package com.example.jpademo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPublisher is a Querydsl query type for Publisher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPublisher extends EntityPathBase<Publisher> {

    private static final long serialVersionUID = 1290090514L;

    public static final QPublisher publisher = new QPublisher("publisher");

    public final com.example.jpademo.entity.common.QBaseEntity _super = new com.example.jpademo.entity.common.QBaseEntity(this);

    public final ListPath<Book, QBook> books = this.<Book, QBook>createList("books", Book.class, QBook.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> publisherId = createNumber("publisherId", Long.class);

    public final StringPath publisherName = createString("publisherName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QPublisher(String variable) {
        super(Publisher.class, forVariable(variable));
    }

    public QPublisher(Path<? extends Publisher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPublisher(PathMetadata metadata) {
        super(Publisher.class, metadata);
    }

}

