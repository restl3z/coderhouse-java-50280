SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS users;
CREATE TABLE users (id int NOT NULL AUTO_INCREMENT, name varchar(150) NOT NULL, email varchar(150) NOT NULL, PRIMARY KEY (id));
DROP TABLE IF EXISTS products;
CREATE TABLE products (id int NOT NULL AUTO_INCREMENT, name varchar(150) NOT NULL, price int NOT NULL, PRIMARY KEY (id));
DROP TABLE IF EXISTS sales;
CREATE TABLE sales (id int NOT NULL AUTO_INCREMENT, productID int NOT NULL, productName varchar(150) NOT NULL, userID int NOT NULL, userName varchar(150) NOT NULL, userEmail varchar(150) NOT NULL, PRIMARY KEY (id), FOREIGN KEY (productID) REFERENCES products(id), FOREIGN KEY (userID) REFERENCES users(id));
SET FOREIGN_KEY_CHECKS = 1;