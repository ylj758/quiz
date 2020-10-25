DROP TABLE IF EXISTS product_order_contact;
CREATE TABLE product_order_contact (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_id int(11) NOT NULL,
  order_id int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
INSERT INTO product_order_contact VALUES ('1', '1', '1');
INSERT INTO product_order_contact VALUES ('2', '2', '1');
INSERT INTO product_order_contact VALUES ('3', '2', '2');
