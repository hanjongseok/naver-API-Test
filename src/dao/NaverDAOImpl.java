package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import db.DB;
import dto.NaverDTO;

public class NaverDAOImpl implements NaverDAO {

	@Override
	public void insert(NaverDTO dto) {

		// DB연결
		// 쿼리 만들고
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn();
			String sql = "INSERT INTO n_tbl (`title`, `originallink`, `link`, `description`, `pubDate`) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getOriginallink());
			pstmt.setString(3, dto.getLink());
			pstmt.setString(4, dto.getDescription());
			pstmt.setString(5, dto.getPubDate());
			

			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	

}
