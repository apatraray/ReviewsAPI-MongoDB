create table products(
    ID int not null AUTO_INCREMENT,
    product_name varchar(255) not null,
    product_price varchar(255) not null,
    constraint products_pk PRIMARY KEY (ID)
);
