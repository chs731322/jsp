package mapper;

import java.util.List;

import dto.GroupMemberDTO;
import dto.PostDTO;

public interface PostMapper {

    // 게시글 삽입
    int insertPost(PostDTO dto);

    // 게시글 목록 조회 (단일 아이템 조회 포함)
    List<PostDTO> getPostItem();

    // 특정 조건에 따른 게시글 목록 조회
    List<PostDTO> getPostlist(PostDTO postDTO);

    // 게시글 삭제
    int deletePost(PostDTO dto);

    // 그룹 멤버 삽입
    int insertGroupMember(PostDTO dto);

    // 그룹 삽입
    int insertGroup(PostDTO dto);

    // 특정 OTT 조건으로 검색
    List<PostDTO> searchott(PostDTO dto);

    // 그룹 삭제
    int deleteGroup(String postnum);

    // 게시글 삭제
    int deletePost(String postnum);

    // 플랫폼별 게시글 리스트 조회
    List<PostDTO> platformnumPostList(String platformnum);

    // 게시글 번호로 게시글 검색
    PostDTO searchpostnum(String postnum);

	int updatePayment(GroupMemberDTO groupMemberDTO);
}
