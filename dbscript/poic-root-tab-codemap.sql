--����
create table wis_code_map(
  code_id varchar(20) not null comment '����id',
  code_desc varchar(20) not null comment '����˵��',
  attribute1 varchar(500)  comment '������1',
  attribute2 varchar(11)  comment '������2',
  attribute3 char(2)  comment '������3',
  date_created datetime comment '��������',
  date_updated datetime comment '�޸�����',
  created_by varchar(20) comment '������',
  updated_by varchar(20) comment '������'
);

--������
create unique index wis_codemap_codeid on wis_codemap(code_id);

--��ʼ������
insert into wis_code_map values('code1','��̬���ؿ���1','Y','','',now(),now(),'sys','sys');
insert into wis_code_map values('code2','��̬���ؿ���1','Y','','',now(),now(),'sys','sys');
insert into wis_code_map values('code3','��̬���ؿ���1','N','','',now(),now(),'sys','sys');