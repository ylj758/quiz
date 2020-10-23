DROP TABLE IF EXISTS product_order_contact;
CREATE TABLE orders (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_id varchar(11) DEFAULT NULL,
  order_id varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
INSERT INTO orders VALUES ('1', '1', '1');
INSERT INTO orders VALUES ('2', '2', '1');
INSERT INTO orders VALUES ('3', '2', '2');
