package mapper;

import java.util.List;

import dto.PostDTO;


public interface PostMapper {

	int insertPost(PostDTO dto);
	List<PostDTO> getPostItem();
	List<PostDTO> getPostlist(PostDTO postDTO);
	int deletePost(PostDTO dto);
	int insertGroupMember(PostDTO dto);
	List<PostDTO> insertGroupMember();
	List<PostDTO> getPostList();
	PostDTO searchpostnum(String postnum);
}
