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
                         '아쉽네 2등했네',
                         '1234',
                         '127.0.0.1',
                         sysdate );
 
--update : where절생략시 모든행 처리

update visit  
         set name   ='이준기',
             content='~~~',
             pwd='1111',
             ip='192.168.0.222',
             regdate=sysdate
where idx=7
                                                                                                    
                                                                                                                                                    
select * from visit  order by idx desc

rollback

commit
                                              




*/






