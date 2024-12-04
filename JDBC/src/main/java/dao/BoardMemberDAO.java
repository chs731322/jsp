package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardMemberDTO;
import oracle.jdbc.pool.OracleDataSource;

public class BoardMemberDAO {

	// 싱글톤 패턴 적용
	// 1. 클래스의 단일 인스턴스를 저장하기 위한 정적 변수
	private static BoardMemberDAO instance = new BoardMemberDAO();

	private OracleDataSource ods;

	// 2. 생성자를 private으로 선언하여 외부에서 인스턴스 생성 불가
	private BoardMemberDAO() {
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@nam3324.synology.me:32800/xe");
            ods.setUser("c##quest");
            ods.setPassword("tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 3. 클래스의 인스턴스를 반환하는 메서드
	// 최초 호출 시에만 인스턴스를 생성하며, 이후에는 기존 인스턴스를 반환
	// 동기화 블록으로 멀티스레드 환경에서도 안전하게 작동

	public static BoardMemberDAO getInstance() {
		if (instance == null) {
			instance = new BoardMemberDAO();
		}
		return instance;
	}

	public ArrayList<BoardMemberDTO> selectAllMember() {
		ArrayList<BoardMemberDTO> list = new ArrayList<BoardMemberDTO>();
		// 1. SQl문 작성
		String sql = "select * from board_member";
		// 2. Connection 받아옴
		// 3. PreparedStatement 생성
		try(Connection conn = ods.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			// 4. SQL문 실행
			try(ResultSet rs = pstmt.executeQuery();){
				// 5. 결과 처리
				while(rs.next()) {
					BoardMemberDTO dto = new BoardMemberDTO();
					dto.setId(rs.getString("id"));
					dto.setPassword(rs.getString("password"));
					dto.setUserName(rs.getString("username"));
					dto.setNickName(rs.getString("nickname"));
					
					list.add(dto);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 6. 결과값 리턴

		return list;
	}

}
