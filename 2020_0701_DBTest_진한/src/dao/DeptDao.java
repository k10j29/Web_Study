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
C reate 관리 (insert 명령)
R ead 관리 (Select 명령)
U pdate (Update)
D elete (Delete)

*
*/
public class DeptDao {

	// single-ton : 객체 1개만생성해서 사용(서비스)하자
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
	}

	// 1.// DB접속 해서 부서 조회
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();
		String sql = "select * from sawon";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			// 3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			// 전체레코드를 vo로 포장후 ArrayList에 추가
			while (rs.next()) {
				// record를 담을 객체 생성
				DeptVo vo = new DeptVo();

				// record->vo로 옮긴다
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));

//				int sabun;
//				String saname;
//				String sasex;
//				int deptno;
//				String sajob;
//				String sahire;
//				int samgr;
//				int sapay;

				// ArrayList추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally { // 열린것 역순으로 닫기 Connection 닫기 (DBservice 가 basic data source로 부터 받은)

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
