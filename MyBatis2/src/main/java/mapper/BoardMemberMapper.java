package mapper;

import java.util.List;

import dto.BoardMemberDTO;

public interface BoardMemberMapper {
	// Mapper에서 id 속성값과 추상 메서드명으로 실행할 sql문을 찾아서 실행
	List<BoardMemberDTO> selectAllMember();
	int insertMember(BoardMemberDTO dto);
	List<BoardMemberDTO> selectNameMember(String name);
	int deleteMember(String id);

}
