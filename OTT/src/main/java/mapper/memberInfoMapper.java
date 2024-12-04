package mapper;

import dto.UsersDTO;

public interface memberInfoMapper {

	int insertMember(UsersDTO dto);

	int updateMemberInfo(UsersDTO dto);
	
	int deleteMember(String memberNum);

	UsersDTO selectUserById(String id);


}