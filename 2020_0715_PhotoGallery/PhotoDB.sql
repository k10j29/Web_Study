
create sequence seq_photo_p_idx



create table photo
(

	p_idx int,								--일련번호 (Primary Key)
	p_title varchar2(100) not null,         --제목
	p_content varchar2(2000) not null,		--내용 (설명)
	p_filename varchar2(500) not null,		--파일이름
	p_ip varchar2(100) not null,			--아이피
	p_regdate date,							--등록일자
	m_idx int								--회원번호 (Foreign Key)
	
)

DROP TABLE photo

-- 기본키  설정 (Primary)
alter table photo add constraint pk_photo_p_idx primary key(p_idx);

-- 참조키, 외래키 설정 (Foreign)

-- 삭제
alter table photo drop constraint fk_photo_m_idx

alter table photo add constraint fk_photo_m_idx foreign key(m_idx)
											references member (m_idx)
											on delete cascade ;
											
select * from member 
											
--sample data insert 

insert into photo values(seq_photo_p_idx.nextVal,'곰돌이다','19곰 테드 입니다.','19TED.png','127.0.0.1',sysdate,4);

delete  photo where p_idx = '3'
delete  photo where p_idx = '21'
delete  photo where p_idx = '5'

commit

create or replace view photo_view
as

select p.* ,m.m_name from photo p inner join member m on p.m_idx=m.m_idx

order by p_idx desc

select * from photo_view



											
											
											
											
											
											
											









