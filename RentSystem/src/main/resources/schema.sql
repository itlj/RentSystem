drop table if exists student;
drop table if exists master;
drop table if exists house;
create table student (
  id int identity primary key,
  name varchar(25) not null,
  password varchar(25)  not null,
  phonenumber varchar(25) not null,
  address varchar(50) not null,
  brithday varchar(25) not null,
  sex varchar(25) not null
);

create table master (
  id int identity primary key,
  name varchar(25) not null,
  password varchar(25)  not null,
  phonenumber varchar(25) not null,
  address varchar(50) not null,
);

create table house (
  id int identity(1,1) primary key,
  masterid int not null,
  address varchar(50) not null,
  type varchar(25) not null,
  capacity varchar(25) not null,
  price varchar(25) not null,
  status varchar(25) not null,
  foreign key(masterid) references master(id)
);

create table student_house (
  id int identity(1,1) primary key,
  masterid int not null,
  studentid int not null,
  houseid int not null,
  meetplace varchar(25) not null,
  meettime varchar(25) not null,
  foreign key(masterid) references master(id),
  foreign key(studentid) references student(id),
  foreign key(houseid) references house(id)
);

create table mastermsg (
  id integer identity primary key,
  masterid int not null,
  houseid int not null,
  category varchar(50) not null,
  price varchar(50) not null,
  postedtime varchar(50) not null,
  foreign key(masterid) references master(id),
  foreign key(houseid) references house(id)
);