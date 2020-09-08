-- Create table
create table FACE_SYS_MODULE
(
  ID        VARCHAR2(16) not null,
  NAME      VARCHAR2(64),
  URL       VARCHAR2(100),
  PARENT_ID VARCHAR2(16),
  SORT      NUMBER,
  ICON      VARCHAR2(16),
  DESCRIBE  VARCHAR2(64),
  CODE      VARCHAR2(16),
  FLAG      VARCHAR2(2)
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
comment on column FACE_SYS_MODULE.FLAG
  is '0删除，1未删除';
-- Create/Recreate primary, unique and foreign key constraints
alter table FACE_SYS_MODULE
  add constraint MODULE_PRIMARY primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
