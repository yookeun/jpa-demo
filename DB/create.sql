-- demo.book definition

-- demo.publisher definition

CREATE TABLE `publisher`
(
    `publisher_id`   bigint    NOT NULL AUTO_INCREMENT,
    `publisher_name` varchar(100)   DEFAULT NULL,
    `create_date`    timestamp NULL DEFAULT NULL,
    `update_date`    timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`publisher_id`)
) ENGINE = InnoDB;


CREATE TABLE `book`
(
    `book_id`      bigint    NOT NULL AUTO_INCREMENT,
    `title`        varchar(100)   DEFAULT NULL,
    `isbn`         varchar(50)    DEFAULT NULL,
    `author`       varchar(50)    DEFAULT NULL,
    `price`        double         DEFAULT NULL,
    `publisher_id` bigint         DEFAULT NULL,
    `state`        varchar(50)    DEFAULT NULL,
    `create_date`  timestamp NULL DEFAULT NULL,
    `update_date`  timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`book_id`)
) ENGINE = InnoDB;

-- demo.`member` definition

CREATE TABLE `member`
(
    `member_id`   bigint    NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(50)                            DEFAULT NULL,
    `user_name`   varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_date` timestamp NULL                         DEFAULT NULL,
    `update_date` timestamp NULL                         DEFAULT NULL,
    PRIMARY KEY (`member_id`)
) ENGINE = InnoDB;


CREATE TABLE `item`
(
    `item_id`     bigint    NOT NULL AUTO_INCREMENT,
    `item_name`   varchar(50)                            DEFAULT NULL,
    `item_type`   varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_date` timestamp NULL                         DEFAULT NULL,
    `update_date` timestamp NULL                         DEFAULT NULL,
    PRIMARY KEY (`item_id`)
) ENGINE = InnoDB;



CREATE TABLE `my_item`
(
    `member_id` bigint NOT NULL ,
    `item_id`   bigint NOT NULL,
    PRIMARY KEY (`member_id`, `item_id`)
) ENGINE = InnoDB;





