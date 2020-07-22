package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.DBService;
import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {

	// Mybatis처리객체
	SqlSessionFactory factory;
	// single-ton : 객체 1개만생성해서 사용(서비스)하자
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

	// 방명록 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		SqlSession sqlSession = factory.openSession();

		// 작업(요청)수행
		list = sqlSession.selectList("visit.visit_list");

		sqlSession.close();

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		// DML 명령 에서는 트랜잭션 처리 잘해주기

		// 작업세션 얻기 (true = autocommit)
		SqlSession sqlSession = factory.openSession(true);

		// 작업수행
		res = sqlSession.insert("visit.visit_insert", vo);

		// 트랜잭션 commit (DB에 적용):적용 할것인지 rollback (되돌릴것인지):취소

		// sqlSession.commit(); // 수동으로하는 방법

		// 반납
		sqlSession.close();

		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1
		String sql = "delete from visit where idx=?";

		try {
			// 1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setInt(1, idx);

			// 4.DB 처리: insert/update/delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		String sql = "select * from visit where idx=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			// 2-1.pstmt parameter
			pstmt.setInt(1, idx);

			// 3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			// 전체레코드를 vo로 포장후 반환
			if (rs.next()) {
				// record를 담을 객체 생성
				vo = new VisitVo();

				// record->vo로 옮긴다
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = // 1 2 3 4 5
				"update visit set name=?,content=?,pwd=?,ip=?,regdate=sysdate where idx=?";

		try {
			// 1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());

			// 4.DB 처리: insert/update/delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

}
