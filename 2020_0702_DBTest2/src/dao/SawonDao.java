package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SawonVo;

public class SawonDao {

	//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static SawonDao single = null;

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();
		return single;
	}

	public SawonDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SawonVo> selectList() {

		List<SawonVo> list = new ArrayList<SawonVo>();
		String sql = "select * from sawon";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			//전체레코드를 vo로 포장후 ArrayList에 추가
			while (rs.next()) {
				//record를 담을 객체 생성
				SawonVo vo = new SawonVo();

				//record->vo로 옮긴다
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
				//ArrayList추가
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
	
	
	
}
