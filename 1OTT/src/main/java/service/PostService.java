package service;

import java.util.List;

import config.DBManager;

import dto.PostDTO;
import mapper.PostMapper;

public class PostService {
	
	private PostMapper postMapper;

	private static PostService instance = new PostService();
	
	private PostService() {	
		postMapper = DBManager.getInstance().getSession().getMapper(PostMapper.class);
	}

	
	public static PostService getInstance() {
		if(instance == null)
			instance = new PostService();
		return instance;
	}
	
	public int insertPost(PostDTO postDto) {
		return postMapper.insertPost(postDto);
	}
	
	
	public List<PostDTO> getPostItem() {
		return postMapper.getPostItem();
	}
	
	public List<PostDTO> getPostlist(PostDTO postDTO) {
		return postMapper.getPostlist(postDTO);
	}
	
	public int deletePost(PostDTO postDto) {
		return postMapper.deletePost(postDto);
	}


	public int insertGroup(PostDTO dto) {
		return postMapper.insertPost(dto);
	}


	public int insertGroupMember(PostDTO dto) {
		return postMapper.insertGroupMember(dto);
	}


	public List<PostDTO> getPostList() {
		return postMapper.getPostList();
	}


	public PostDTO searchpostnum(String postnum) {
		return postMapper.searchpostnum(postnum);
	}

}