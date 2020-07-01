package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.DeptVo;

/*
 * 
 * DAO ( Data Access Object) 
C reate ���� (insert ����)
R ead ���� (Select ����)
U pdate (Update)
D elete (Delete)

*
*/
public class DeptDao {

	// single-ton : ��ü 1���������ؼ� ���(����)����
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
	}

	// 1.// DB���� �ؼ� �μ� ��ȸ
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();
		String sql = "select * from dept";

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
				DeptVo vo = new DeptVo();

				// record->vo�� �ű��
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));

				// ArrayList�߰�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally { // ������ �������� �ݱ� Connection �ݱ� (DBservice �� basic data source�� ���� ����)

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

}