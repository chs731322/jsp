package dao;

import config.DBManager;
import dto.UsersDTO;
import mapper.UsersMapper;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;

public class UsersDAO {

    public UsersDTO selectUserById(String id) {
        try (SqlSession session = DBManager.getInstance().getSession()) {
            UsersMapper mapper = session.getMapper(UsersMapper.class);
            return mapper.selectUserById(id);
        }
    }

    public int insertUser(UsersDTO user) {
        try (SqlSession session = DBManager.getInstance().getSession()) {
            UsersMapper mapper = session.getMapper(UsersMapper.class);
            return mapper.insertUser(user);
        }
    }

}
