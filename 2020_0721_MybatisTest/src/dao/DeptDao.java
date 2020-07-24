package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {

	//Mybatis기능처리 객체
	SqlSessionFactory factory;
	
	//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//부서목록
	public List<DeptVo> selectList(){
		
		List<DeptVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("dept.dept_list");
		
		sqlSession.close();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
