create table comments (
    ID int not null AUTO_INCREMENT,
    comment_type varchar(255) not null,
    comment_detail varchar(255) not null,
    review_id int,
    constraint comments_pk PRIMARY KEY (ID),
    constraint comments_fk foreign key(review_id) references reviews(ID)
);