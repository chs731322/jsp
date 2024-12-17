package service;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dao.UsersDAO;
import dto.UsersDTO;
import mapper.UsersMapper;

public class UserService {
	private static UserService instance = new UserService();

	public UserService() {		}

	public static UserService getInstance() {
		if (instance == null)
			instance = new UserService();
		return instance;
	}
	
	public UsersDTO selectUserById(String id) {
	    try (SqlSession session = DBManager.getInstance().getSession()) {
	        UsersMapper mapper = session.getMapper(UsersMapper.class);
	        return mapper.selectUserById(id);
	    }
	}

	public int deleteUser(String id) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			UsersMapper mapper = session.getMapper(UsersMapper.class);
			return mapper.deleteUser(id);
		}

	}

	public int updateUserInfo(UsersDTO dto) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
			UsersMapper mapper = session.getMapper(UsersMapper.class);
			return mapper.updateUserInfo(dto);
		}
	}

	 public static boolean isIdAvailable(String id) {
	        try (SqlSession session = DBManager.getInstance().getSession()) {
	            UsersMapper mapper = session.getMapper(UsersMapper.class);
	            return mapper.selectUserById(id) == null; // ID가 없으면 사용 가능
	        }
	    }

	public int profileUpdate(UsersDTO user) {
		try (SqlSession session = DBManager.getInstance().getSession()) {
	        UsersMapper mapper = session.getMapper(UsersMapper.class);
	        int result = mapper.profileUpdate(user);
	        session.commit(); // 변경 사항 반영
	        return result;
	    }
	}
}