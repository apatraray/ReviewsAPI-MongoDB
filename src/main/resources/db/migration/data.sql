
INSERT INTO products (ID, product_name, product_price) VALUES (1, "smart watches", "$199", 1);
INSERT INTO products (ID, product_name, product_price, review_id) VALUES (2, "Lego toys", "$50", 2);

INSERT INTO reviews (ID, product_id) VALUES (1, 1);
INSERT INTO reviews (ID, product_id) VALUES (2, 2);

INSERT INTO comments (ID, comment_type, comment_detail, review_id) VALUES (1, "very good", "works perfect", 1);
INSERT INTO comments (ID, comment_type, comment_detail, review_id) VALUES (2, "good", "stylish outlook", 1);