package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungTBDao {

	// single-ton : 객체 1개만생성해서 사용(서비스)하자
	static SungTBDao single = null;

	public static SungTBDao getInstance() {

		if (single == null)
			single = new SungTBDao();
		return single;
	}

	public SungTBDao() {
		// TODO Auto-generated constructor stub
	}

	// 성적조회
	public List<SungVo> selectList() {

		List<SungVo> list = new ArrayList<SungVo>();
		String sql = "select * from sungtb_view";

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
				SungVo vo = new SungVo();

				// record->vo로 옮긴다
				// int no = rs.getInt("no");
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getInt("rank"));

				// ArrayList추가
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

	public int insert(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = // parameter index=> 1 2 3 4
				"insert into sungtb values(seq_sungtb_no.nextVal,?,?,?,?)";

		try {
			// 1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());

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

	// 수정
	public int update(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = // 1 2 3 4 5
				"update sungtb set name=?,kor=?,eng=?,mat=? where no=?";

		try {
			// 1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getNo());

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

	// 삭제
	public int delete(int no) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sungtb where no=?";

		try {
			// 1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setInt(1, no);

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

	public SungVo selectOne(int no) {

		SungVo vo = null; // 1
		String sql = "select * from sungtb_view where no=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			// 2-1.pstmt parameter 설정
			pstmt.setInt(1, no);

			// 3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			// 전체레코드를 vo로 포장후 반환
			if (rs.next()) {
				// record를 담을 객체 생성
				vo = new SungVo();

				// record->vo로 옮긴다
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getInt("rank"));

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

}
