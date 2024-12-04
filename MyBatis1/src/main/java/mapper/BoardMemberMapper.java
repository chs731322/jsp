package mapper;

import java.util.List;

import config.DBManager;
import dto.BoardMemberDTO;

public class BoardMemberMapper {
	private static BoardMemberMapper instance = new BoardMemberMapper();
	private DBManager manager;

	public BoardMemberMapper() {
		manager = DBManager.getInstance();
	}
	
	public static BoardMemberMapper getInstance() {
		if(instance == null)
			instance = new BoardMemberMapper();
		return instance;
	}
	
	public List<BoardMemberDTO> selectAllMember() {
										// member-mapper.xml에 있는 아이디 속성값으로 실행
		return manager.getSession().selectList("selectAllMember");
	}
	
}
