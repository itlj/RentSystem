insert into student (name,password,phoneNumber,address,brithday,sex) values ('张三', '8888', '13333333333', '华侨大学','1997-9-25','男');
insert into student (name,password,phoneNumber,address,brithday,sex) values ('李四', '8888', '14444444444', '华侨大学','1997-9-25','男');

insert into master (name,password,phoneNumber,address) values ('王五', '8888', '15555555555', '厦门大学');
insert into master (name,password,phoneNumber,address) values ('赵六', '8888', '16666666666', '厦门大学');

insert into house (masterId,address,type,capacity,price,status) values ('1','滨水小区1-6','单间','1','1000','是');
insert into house (masterId,address,type,capacity,price,status) values ('2','滨水小区2-5','套间','2','800','是');

insert into masterMsg (masterId,category,price,postedtime,houseid) values('1','上传房屋','50RMB','2018-7-3 15:30','1');
insert into masterMsg (masterId,category,price,postedtime,houseid) values('2','上传房屋','50RMB','2018-7-3 15:30','2');

insert into student_house (masterId,studentid,houseid,meetplace,meettime) values('1','1','1','郑年锦图书馆','2018-7-2 14:00');
insert into student_house (masterId,studentid,houseid,meetplace,meettime) values('2','2','2','郑年锦图书馆','2018-7-2 14:00');