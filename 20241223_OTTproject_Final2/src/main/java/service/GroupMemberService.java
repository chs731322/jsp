package service;

import java.time.LocalDateTime;
import java.util.List;

import config.DBManager;
import dto.GroupMemberDTO;
import mapper.GroupMemberMapper;

public class GroupMemberService {
	
	private static GroupMemberService instance = new GroupMemberService();
	private GroupMemberMapper mapper;
	
	
	private GroupMemberService() {	
		mapper = DBManager.getInstance().getSession().getMapper(GroupMemberMapper.class);
	}

	
	public static GroupMemberService getInstance() {
		if(instance == null)
			instance = new GroupMemberService();
		return instance;
	}


	public GroupMemberDTO getGroupMemberInfo(String id, String gno, String platformNum) {
		return mapper.getGroupMemberInfo(id, gno, platformNum);
	}


	public int updatePayment(GroupMemberDTO dto) {
		return mapper.updatePayment(dto);
	}


	public List<GroupMemberDTO> getGroupMemberById(String id) {
		return mapper.getGroupMemberById(id);
	}


	public int deleteGM(String postnum) {
		return mapper.deleteGM(postnum);
	}

	public void resetExpiredPayments() {
		mapper.resetExpiredPayments();
	   
	}

	public List<GroupMemberDTO> getAllGroupMembers() {
		return mapper.getAllGroupMembers();
	}
	
	// payment만 업데이트
    public int updateOnlyPayment(GroupMemberDTO dto) {
        return mapper.updateOnlyPayment(dto);
    }
}
