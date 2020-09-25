DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
  id int(11) NOT NULL,
  count int(11) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  price int(11) DEFAULT NULL,
  unit varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
INSERT INTO orders VALUES ('1', '3', '可乐', '3', '元');
INSERT INTO orders VALUES ('2', '4', '雪碧', '3', '元');
-- ----------------------------

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id int(11) NOT NULL,
  img varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  price int(11) DEFAULT NULL,
  unit varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
INSERT INTO product VALUES ('1', '1.png', '可乐', '3', '元/瓶');
INSERT INTO product VALUES ('2', '1.png', '雪碧', '3', '元/瓶');
INSERT INTO product VALUES ('3', '1.png', '桃子', '3', '元/瓶');
INSERT INTO product VALUES ('4', '1.png', '荔枝', '3', '元/瓶');
INSERT INTO product VALUES ('5', '1.png', '电池', '3', '元/瓶');
INSERT INTO product VALUES ('6', '1.png', '泡面', '3', '元/瓶');
