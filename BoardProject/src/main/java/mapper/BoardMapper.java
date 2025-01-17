package mapper;

import java.util.List;
import java.util.Map;

import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.BoardFileDTO;

public interface BoardMapper {
	//페이지별 게시글 목록 조회	
	List<BoardDTO> getBoardList();
	//게시글 등록
	int insertBoard(BoardDTO dto);
	BoardDTO selectBoard(int bno);
	int updateBoardCount(int bno);
	int insertBoardComment(BoardCommentDTO dto);
	List<BoardCommentDTO> getCommentList(int bno);
	int deleteBoard(int bno);
	int deleteBoardComment(int cno);
	int updateBoard(BoardDTO dto);
	int selectBoardNo();
	int insertBoardFile(BoardFileDTO item);
	List<BoardFileDTO> getBoardFileList(int bno);
	String selectFilePath(int fno);
	int insertBoardLike(Map<String, Object> map);
	int deleteBoardLike(Map<String, Object> map);
	int getBoardLike(int bno);
	int getBoardHate(int bno);
	int insertBoardHate(Map<String, Object> map);
	int deleteBoardHate(Map<String, Object> map);
	int insertBoardCommentLike(Map<String, Object> map);
	int deleteBoardCommentLike(Map<String, Object> map);
	int getBoardCommentLike(int cno);
	int getBoardCommentHate(int bno);
	int insertBoardCommentHate(Map<String, Object> map);
	int deleteBoardCommentHate(Map<String, Object> map);

}



