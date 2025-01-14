package mapper;


import java.util.List;

import dto.GroupMemberDTO;

public interface GroupMemberMapper {

	    GroupMemberDTO getGroupMemberInfo(String id, String gno, String platformNum);

		int updatePayment(GroupMemberDTO dto);

		List<GroupMemberDTO> getGroupMemberById(String id);

		int deleteGM(String postnum);

		void resetExpiredPayments();

		List<GroupMemberDTO> getAllGroupMembers();

		int updateOnlyPayment(GroupMemberDTO dto);

}
