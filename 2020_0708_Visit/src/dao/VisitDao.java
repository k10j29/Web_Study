package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {

	// single-ton : ��ü 1���������ؼ� ���(����)����
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}

	public VisitDao() {
		// TODO Auto-generated constructor stub
	}

	// ����� ��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();
		String sql = "select * from visit order by idx desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Connection ������
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);

			// 3.ResultSet������
			rs = pstmt.executeQuery();

			// ��ü���ڵ带 vo�� ������ ArrayList�� �߰�
			while (rs.next()) {
				// record�� ���� ��ü ����
				VisitVo vo = new VisitVo();

				// record->vo�� �ű��
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				// ArrayList�߰�
				list.add(vo);
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

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1 2 3 4
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

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

	// ����
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = // 1 2 3 4 5
				"update visit set contnet=? where idx=?";

		try {
			// 1.Connection ���
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setString(1, vo.getContent());

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

	// ����
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
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

}