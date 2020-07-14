
--일련번호 관리 대신.. inline view 형식의 쿼리 사용할것임

MySQL 이나 다른 서버에서도 사용하는 방법 (시퀸스 사용하지않고)

 (2)

select nvl(max(m_idx),0) + 1 from member


--회원 Table 만들기 (1)

create table member
(


-- member (m)_

m_idx 				  int,           		  		-- 일련번호
m_id				  varchar2(100) not null,  		-- 아이디
m_name 				  varchar2(100) not null,		-- 이름
m_pwd				  varchar2(100) not null, 		-- 패스워드
m_zipcode			  varchar2(100) not null,   	-- 도로명번호
m_addr 			      varchar2(500) not null,     	-- 집주소
m_ip 			      varchar2(500) not null,     	-- 등록한 주소 
m_regdate 			  date							-- 가입일자


)


--컬럼 추가 일반 / 관리자 (5)

alter table member add m_grade varchar2(100);


-- 제약조건 


-- 기본키 설정 (3)

alter table member
	add constraint pk_member_m_idx primary key(m_idx)
	
-- unique (4)

	alter table member
	add constraint unique_member_m_id unique(m_id)
	
	
	
--Sample  

	--관리자 회원 등록 (6)

insert into member values( (select nvl(max(m_idx),0) + 1 from member),
                           'admin',
                           '관리자',
                           '1234',
                           '12345',
                           '서울 관악 신림동',
                           '127.0.0.1',
                           sysdate,
                           '관리자'
                    ); 
	
	--일반 회원 등록 (7)
	
		insert into member values( (select nvl(max(m_idx),0) + 1 from member),
                           'hong',
                           '홍길동',
                           '1234',
                           '12345',
                           '서울 관악 신림1동',
                           '127.0.0.1',
                           sysdate,
                           '일반'
                    ); 
                    
	
	
	select * from member
	
	select * from member where m_idx=2
	
	commit



