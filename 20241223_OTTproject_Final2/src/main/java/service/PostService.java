package service;

import java.time.LocalDateTime;
import java.util.List;

import config.DBManager;
import dto.GroupMemberDTO;
import dto.PostDTO;
import mapper.PostMapper;

public class PostService {

    private PostMapper postMapper;
    private static PostService instance = new PostService();

    private PostService() {
        postMapper = DBManager.getInstance().getSession().getMapper(PostMapper.class);
    }

    public static PostService getInstance() {
        if (instance == null)
            instance = new PostService();
        return instance;
    }

    // 게시글 삽입
    public int insertPost(PostDTO postDto) {
        return postMapper.insertPost(postDto);
    }

    // 게시글 아이템 가져오기
    public List<PostDTO> getPostItem() {
        return postMapper.getPostItem();
    }

    // 게시글 목록 가져오기
    public List<PostDTO> getPostlist(PostDTO postDTO) {
        return postMapper.getPostlist(postDTO);
    }

    // 게시글 삭제
    public int deletePost(String postnum) {
        return postMapper.deletePost(postnum);
    }

    // 그룹 멤버 삽입
    public int insertGroupMember(PostDTO dto) {
        return postMapper.insertGroupMember(dto);
    }

    // 그룹 삽입
    public int insertGroup(PostDTO dto) {
        return postMapper.insertGroup(dto);
    }

    // 특정 OTT 검색
    public List<PostDTO> searchott(PostDTO dto) {
        return postMapper.searchott(dto);
    }

    // 그룹 삭제
    public int deleteGroup(String postnum) {
        return postMapper.deleteGroup(postnum);
    }

    // 플랫폼별 게시글 리스트 가져오기 (with nowNum 계산)
//    public List<PostDTO> platformnumPostList(String platformnum) {
//        List<PostDTO> postList = postMapper.platformnumPostList(platformnum);
//        for (PostDTO post : postList) {
//            int nowNum = postMapper.platformnumPostList(platformnum).size(); // 현재 그룹 인원 계산
//            post.setNowNum(nowNum); // PostDTO에 nowNum 설정
//        }
//        return postList;
//    }
    public List<PostDTO> platformnumPostList(String platformnum) {
        return postMapper.platformnumPostList(platformnum); // DTO에 매핑된 nownum 값을 직접 반환
    }


    // 게시글 번호로 게시글 검색
    public PostDTO searchpostnum(String postnum) {
        return postMapper.searchpostnum(postnum);
    }

}
