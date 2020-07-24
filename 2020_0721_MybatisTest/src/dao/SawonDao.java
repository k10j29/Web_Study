package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	//SessionFactory생성하는 객체
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance()
				                  .getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	
	//목록조회
	public List<SawonVo>  selectList(){
		
		List<SawonVo> list = null;
		//1.Mybatis 작업세션(자) 얻어오기
		//  Myabtis객체에서 Connection획득
		SqlSession sqlSession = factory.openSession();
		
		//2.실행                      mapper에 선언된 id
		//                            namespace.id
		list = sqlSession.selectList("sawon.sawon_list");		
		
		//3.닫기(반환) : 얻어온 Connection 반납
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		//1.Mybatis 작업세션(자) 얻어오기
		//  Myabtis객체에서 Connection획득
		SqlSession sqlSession = factory.openSession();
		
		//2.실행                      mapper에 선언된 id
		//                            namespace.id
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);		
		
		//3.닫기(반환) : 얻어온 Connection 반납
		sqlSession.close();
		
		return list;
	}
	
	
	
	
	
	
	
}
