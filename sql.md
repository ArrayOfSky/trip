DROP TABLE users;
DROP TABLE products;
DROP TABLE kinds;
DROP TABLE status;
DROP TABLE orders;

CREATE DATABASE trip;
USE trip;

CREATE table if NOT EXISTS users (
user_id INT auto_increment NOT NULL,
user_name VARCHAR ( 20 ),
user_password VARCHAR ( 20 ),
user_phone_number VARCHAR ( 11 ),
user_consumption DOUBLE ( 10, 2 ),
user_balance DOUBLE ( 10, 2 ),
user_is_vip INT COMMENT 'vip等级',
user_create_time TIMESTAMP,
PRIMARY KEY ( user_id )
);


CREATE table if NOT EXISTS products (
product_id INT auto_increment NOT NULL,
product_name VARCHAR ( 50 ),
product_stock INT COMMENT '现存数量',
product_quantity INT COMMENT '库存(总数)',
product_sales INT COMMENT '已售出量',
product_price DOUBLE ( 10, 2 ),
product_kind INT,
product_status INT,
product_create_time TIMESTAMP,
product_update_time TIMESTAMP,
product_shlf_time TIMESTAMP COMMENT '上架时间',
product_takedown_time TIMESTAMP COMMENT '下架时间',
PRIMARY KEY ( product_id )
);

CREATE table if NOT EXISTS kinds
( kind_id INT PRIMARY KEY auto_increment,
kind_name VARCHAR(20)
);


CREATE table if NOT EXISTS orders (
order_id INT auto_increment NOT NULL,
order_product_id INT NOT NULL,
order_user_id INT NOT NULL,
order_create_time TIMESTAMP,
order_update_time TIMESTAMP,
order_status INT,
order_discount INT,
PRIMARY KEY (order_id)
);



CREATE table if NOT EXISTS status(
status_id INT NOT NULL auto_increment,
status_category VARCHAR (20),
status_name VARCHAR (20),
PRIMARY KEY ( status_id)
);


create table if not exists managers(
manager_id int PRIMARY KEY auto_increment,
manager_account varchar(20),
manager_password varchar(20)
)