DROP TABLE t_user IF EXISTS ;
CREATE TABLE t_user (
  id       BIGINT AUTO_INCREMENT,
  username VARCHAR2(40),
  name     VARCHAR2(20),
  age      INT(3),
  balance  DECIMAL(10, 2),
  PRIMARY KEY (id)
);


