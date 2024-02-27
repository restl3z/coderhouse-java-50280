SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id    int          NOT NULL AUTO_INCREMENT,
    name  varchar(150) NOT NULL,
    email varchar(150) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id    int          NOT NULL AUTO_INCREMENT,
    name  varchar(150) NOT NULL,
    price double       NOT NULL,
    stock int          NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS sale;
CREATE TABLE sale
(
    id           int    NOT NULL AUTO_INCREMENT,
    user_id      int    NOT NULL,
    date         datetime DEFAULT NULL,
    quantity     int    NOT NULL,
    total_amount double NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

DROP TABLE IF EXISTS sale_item;
CREATE TABLE sale_item
(
    id         int NOT NULL AUTO_INCREMENT,
    sale_id    int NOT NULL,
    product_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sale_id) REFERENCES sale (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);

SET FOREIGN_KEY_CHECKS = 1;