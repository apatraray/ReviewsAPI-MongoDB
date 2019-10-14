create table products(
    ID int not null AUTO_INCREMENT,
    product_name varchar(255) not null,
    product_price varchar(255) not null,
    PRIMARY KEY (ID)
);
create table comments (
    ID int not null AUTO_INCREMENT,
    comment_type varchar(255) not null,
    comment_detail varchar(255) not null,
    product_id int,
    PRIMARY KEY (ID)
);
create table reviews (
    ID int not null AUTO_INCREMENT,
    product_id int,
    comment_id int,
    constraint reviews_pk PRIMARY KEY (ID),
	  constraint comment1_fk foreign key(product_id) references products(ID),
	  constraint comment2_fk foreign key(comment_id) references comments(ID)
);