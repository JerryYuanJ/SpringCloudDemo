drop table if EXISTS user;
create table user (
  id int PRIMARY key auto_increment,
  name VARCHAR(255) ,
  age int ,
  desc varchar(255)
)