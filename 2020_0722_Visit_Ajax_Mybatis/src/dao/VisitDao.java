package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {

	
	//Mybatis처리객체
	SqlSessionFactory factory;
	//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}

	public VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	//방명록 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//작업(요청)수행
		list = sqlSession.selectList("visit.visit_list");
		
		sqlSession.close();

		return list;
	}
	
	public List<VisitVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//작업(요청)수행
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		sqlSession.close();

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//DML명령에서는 트랜잭션 옵션 선택 주의
		
		//작업세션 얻기   true: auto commit  false:기본값
		SqlSession sqlSession = factory.openSession(true);
		
		//작업수행
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//트랜잭션 : commit():적용  or rollback():취소
		//sqlSession.commit();//수동
		
		//반납
		sqlSession.close();
		
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//  true : auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행
		res = sqlSession.delete("visit.visit_delete",idx);
		
		//3.반환
		sqlSession.close();
		
		return res;
	}

	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		sqlSession.close();
			

		return vo;
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
	    //  true : auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행
		res = sqlSession.update("visit.visit_update",vo);
		
		//3.반환
		sqlSession.close();
		
		
		return res;
	}

	
	
	
}







