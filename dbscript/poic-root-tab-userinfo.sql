--建表
create table wis_userinfo(
  username varchar(200) not null comment '用户名',
  password varchar(500) not null comment '密码',
  account_id varchar(11) not null comment '账号id',
  account_type char(2) not null comment '账号类型',
  date_created datetime comment '创建日期',
  date_updated datetime comment '修改日期',
  created_by varchar(20) comment '创建人',
  updated_by varchar(20) comment '创建人'
);

--建索引
create index wis_ui_username on wis_userinfo(username);
create index wis_ui_accountid on wis_userinfo(account_id);
--修改自动
alter table wis_userinfo modify account_type varchar(10) not null;
--初始化数据
insert into wis_userinfo values('cp','cp123','F000001','username',now(),now(),'sys','sys');
insert into wis_userinfo values('15889649716','15889649716','F000002','mobile',now(),now(),'sys','sys');
insert into wis_userinfo values('141937@qq.com','1419','F000003','email',now(),now(),'sys','sys');