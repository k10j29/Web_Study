/*

--일련번호 관리객체
create sequence seq_visit_idx

--방명록 테이블
create table visit
(
    idx     int,     					--일련번호
    name    varchar2(100)  not null,	--작성자
    content varchar2(2000) not null,	--내용
    pwd		varchar2(100)  not null,	--비밀번호
    ip		varchar2(100)  not null,	--아이피
    regdate date
)

--기본키
alter table visit  
  add constraint pk_visit_idx primary key(idx)
  
  
--sample data
insert into visit values(seq_visit_idx.nextVal,
                         '일길동',
                         '내가 1등이야~~',
                         '1234',
                         '127.0.0.1',
                         sysdate );
                         
insert into visit values(seq_visit_idx.nextVal,
                         '이길동',
                         '아쉽게 2등이야~~',
                         '1234',
                         '127.0.0.1',
                         sysdate );
                         
select * from visit order by idx desc

commit
                                              




*/






