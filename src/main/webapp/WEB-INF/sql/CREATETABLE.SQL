-- 메뉴 목록
create table menus (
	  menu_id    varchar2(6)  primary key
	, menu_name  varchar2(100)
	, menu_seq   number(5)
);

insert into menus
  values ( 'menu01', 'java', 1 );
  
commit;