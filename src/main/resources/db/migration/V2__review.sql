create table reviews (
    ID int not null AUTO_INCREMENT,
    product_id int,
    constraint reviews_pk PRIMARY KEY (ID),
    constraint reviews_fk foreign key(product_id) references products(ID)
);