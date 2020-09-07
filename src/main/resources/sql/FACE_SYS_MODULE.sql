-- Create table
create table FACE_SYS_MODULE
(
  ID        VARCHAR2(16),
  NAME      VARCHAR2(64),
  URL       VARCHAR2(100),
  PARENT_ID VARCHAR2(16),
  SORT      NUMBER,
  ICON      VARCHAR2(16),
  DESCRIBE  VARCHAR2(64),
  CODE      VARCHAR2(16)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table FACE_SYS_MODULE
  is '菜单';
-- Add comments to the columns 
comment on column FACE_SYS_MODULE.NAME
  is '菜单名称';
comment on column FACE_SYS_MODULE.URL
  is '菜单连接';
comment on column FACE_SYS_MODULE.PARENT_ID
  is '上级id';
comment on column FACE_SYS_MODULE.SORT
  is '排序';
comment on column FACE_SYS_MODULE.ICON
  is '图标';
comment on column FACE_SYS_MODULE.DESCRIBE
  is '描述';
comment on column FACE_SYS_MODULE.CODE
  is '编码';
