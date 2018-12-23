--建表
create table wis_code_map(
  code_id varchar(20) not null comment '配置id',
  code_desc varchar(20) not null comment '配置说明',
  attribute1 varchar(500)  comment '配置项1',
  attribute2 varchar(11)  comment '配置项2',
  attribute3 char(2)  comment '配置项3',
  date_created datetime comment '创建日期',
  date_updated datetime comment '修改日期',
  created_by varchar(20) comment '创建人',
  updated_by varchar(20) comment '创建人'
);

--建索引
create unique index wis_codemap_codeid on wis_codemap(code_id);

--初始化数据
insert into wis_code_map values('code1','动态开关控制1','Y','','',now(),now(),'sys','sys');
insert into wis_code_map values('code2','动态开关控制1','Y','','',now(),now(),'sys','sys');
insert into wis_code_map values('code3','动态开关控制1','N','','',now(),now(),'sys','sys');