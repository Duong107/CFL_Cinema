go
use master
go
drop database ASMJV4
go
create DataBase ASMJV4
go
use ASMJV4
go
CREATE TABLE Users
(
  username VARCHAR(10) NOT NULL,
  fullname nvarchar(255) ,
  password VARCHAR(10) ,
  phonenumber VARCHAR(10) ,
  email nvarchar(255) ,
  locationdetail nvarchar(255) ,
  datecreate DATE ,
  PRIMARY KEY (username)
);
go
CREATE TABLE brand
(
  brandid INT identity NOT NULL,
  namebrand nvarchar(255) ,
  datecreate DATE ,
  PRIMARY KEY (brandid)
);
go
CREATE TABLE Product
(
  productid INT identity NOT NULL,
  name nvarchar(255) ,
  price INT ,
  detail1 nvarchar(255) ,
  size INT ,
  weight FLOAT ,
  display INT ,
  pin INT ,
  powercharge bit ,
  maxsizeml INT ,
  detail2 nvarchar(255) ,
  imagename nvarchar(255) ,
  datecreate DATE ,
  brandid INT NOT NULL,
  PRIMARY KEY (productid),
  FOREIGN KEY (brandid) REFERENCES brand(brandid)
);
go
CREATE TABLE CartDetail
(
  cartid INT identity NOT NULL,
  datecreate DATE ,
  ispay bit ,
  username VARCHAR(10) NOT NULL,
  productid INT NOT NULL,
  PRIMARY KEY (cartid),
  FOREIGN KEY (username) REFERENCES Users(username),
  FOREIGN KEY (productid) REFERENCES Product(productid)
);
go