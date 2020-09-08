-- Create table
create table FACE_SYS_USER
(
  ID          VARCHAR2(16) not null,
  USERNAME    VARCHAR2(32),
  PASSWORD    VARCHAR2(64),
  RANDOMCODE  VARCHAR2(32),
  REALNAME    VARCHAR2(16),
  DEPARTMENT  VARCHAR2(16),
  ROLE_ID     VARCHAR2(16),
  PHONE       VARCHAR2(32),
  IP          VARCHAR2(32),
  CREATE_TIME TIMESTAMP(6),
  EMAIL       VARCHAR2(64),
  UPDATE_TIME TIMESTAMP(6),
  FLAG        VARCHAR2(2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table
comment on table FACE_SYS_USER
  is '用户表';
-- Add comments to the columns
comment on column FACE_SYS_USER.USERNAME
  is '用户名';
comment on column FACE_SYS_USER.PASSWORD
  is '密码';
comment on column FACE_SYS_USER.RANDOMCODE
  is '随机数';
comment on column FACE_SYS_USER.REALNAME
  is '真实姓名';
comment on column FACE_SYS_USER.DEPARTMENT
  is '部门';
comment on column FACE_SYS_USER.ROLE_ID
  is '角色id';
comment on column FACE_SYS_USER.PHONE
  is '电话';
comment on column FACE_SYS_USER.IP
  is 'IP地址';
comment on column FACE_SYS_USER.CREATE_TIME
  is '创建时间';
comment on column FACE_SYS_USER.EMAIL
  is '邮箱';
comment on column FACE_SYS_USER.UPDATE_TIME
  is '更新时间';
comment on column FACE_SYS_USER.FLAG
  is '0删除，1未删除';
-- Create/Recreate primary, unique and foreign key constraints
alter table FACE_SYS_USER
  add constraint ID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
