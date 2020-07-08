/*

--시퀀스(일련번호 관리객체) 

drop   sequence seq_sungtb_no
create sequence seq_sungtb_no

select 
  seq_sungtb_no.nextVal 다음값, 
  seq_sungtb_no.currVal 현재값
from dual

--테이블 생성
create table sungtb
(
   no 	int,					--일련번호
   name varchar2(100) not null,	--이름
   kor	int default 0,			--국어
   eng	int default 0,			--영어
   mat	int default 0			--수학
)

--제약조건
--PK
  alter table sungtb
    add constraint pk_sungtb_no primary key(no);
    
--Check
  alter table sungtb
    add constraint ck_sungtb_kor 
                   check(kor between 0 and 100);
                   
  alter table sungtb
    add constraint ck_sungtb_eng 
                   check(eng between 0 and 100);
  
  alter table sungtb
    add constraint ck_sungtb_mat 
                   check(mat between 0 and 100);                                            
    
--sample data
insert into sungtb values(seq_sungtb_no.nextVal,'일길동',77,88,99);
insert into sungtb values(seq_sungtb_no.nextVal, 
                          '이길동',97,98,99);
insert into sungtb values(seq_sungtb_no.nextVal, 
                          '삼길동',87,88,89);

select * from sungtb

commit

--뷰생성

create or replace view sungtb_view
as
	select
	  no,name,kor,eng,mat,
	  (kor+eng+mat) as tot,
	  round((kor+eng+mat)/3,1) as avg,
	  rank() over( order by (kor+eng+mat) desc) as rank
	from sungtb
	order by no

select * from sungtb_view

select * from sungtb_view where no=63













*/