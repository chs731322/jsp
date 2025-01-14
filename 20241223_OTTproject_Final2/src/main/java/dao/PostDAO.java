package dao;

import config.DBManager;
import dto.PostDTO;
import mapper.PostMapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PostDAO {

    private static PostDAO instance = new PostDAO();

    private PostDAO() {}

    public static PostDAO getInstance() {
        return instance;
    }

    public List<PostDTO> getPostsByPlatform(String platformNum) {
        try (SqlSession session = DBManager.getInstance().getSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.platformnumPostList(platformNum);
        }
    }

    public PostDTO getPostByNumber(String postNum) {
        try (SqlSession session = DBManager.getInstance().getSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.searchpostnum(postNum);
        }
    }

    public int getCurrentGroupCount(String platformNum) {
        try (SqlSession session = DBManager.getInstance().getSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.platformnumPostList(platformNum).size();
        }
    }

    public int insertPost(PostDTO postDTO) {
        try (SqlSession session = DBManager.getInstance().getSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.insertPost(postDTO);
        }
    }
}
