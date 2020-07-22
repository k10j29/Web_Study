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

	// Mybatisó����ü
	SqlSessionFactory factory;
	// single-ton : ��ü 1���������ؼ� ���(����)����
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

	// ���� ��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		SqlSession sqlSession = factory.openSession();

		// �۾�(��û)����
		list = sqlSession.selectList("visit.visit_list");

		sqlSession.close();

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		// DML ��� ������ Ʈ����� ó�� �����ֱ�

		// �۾����� ��� (true = autocommit)
		SqlSession sqlSession = factory.openSession(true);

		// �۾�����
		res = sqlSession.insert("visit.visit_insert", vo);

		// Ʈ����� commit (DB�� ����):���� �Ұ����� rollback (�ǵ���������):���

		// sqlSession.commit(); // ���������ϴ� ���

		// �ݳ�
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
			// 1.Connection ���
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setInt(1, idx);

			// 4.DB ó��: insert/update/delete
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
			// 1.Connection ������
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);

			// 2-1.pstmt parameter
			pstmt.setInt(1, idx);

			// 3.ResultSet������
			rs = pstmt.executeQuery();

			// ��ü���ڵ带 vo�� ������ ��ȯ
			if (rs.next()) {
				// record�� ���� ��ü ����
				vo = new VisitVo();

				// record->vo�� �ű��
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
			// 1.Connection ���
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());

			// 4.DB ó��: insert/update/delete
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
