--����
create table wis_userinfo(
  username varchar(200) not null comment '�û���',
  password varchar(500) not null comment '����',
  account_id varchar(11) not null comment '�˺�id',
  account_type char(2) not null comment '�˺�����',
  date_created datetime comment '��������',
  date_updated datetime comment '�޸�����',
  created_by varchar(20) comment '������',
  updated_by varchar(20) comment '������'
);

--������
create index wis_ui_username on wis_userinfo(username);
create index wis_ui_accountid on wis_userinfo(account_id);
--�޸��Զ�
alter table wis_userinfo modify account_type varchar(10) not null;
--��ʼ������
insert into wis_userinfo values('cp','cp123','F000001','username',now(),now(),'sys','sys');
insert into wis_userinfo values('15889649716','15889649716','F000002','mobile',now(),now(),'sys','sys');
insert into wis_userinfo values('141937@qq.com','1419','F000003','email',now(),now(),'sys','sys');