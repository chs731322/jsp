package mapper;

import java.util.List;

import dto.GroupsDTO;

public interface GroupsMapper {
		int insertGroups(GroupsDTO dto);
		List<GroupsDTO> getGroupsItem();
		List<GroupsDTO> getGroupslist(GroupsDTO groupsDTO);
		int deleteGroups(GroupsDTO dto);
		GroupsDTO getGroupsInfo(GroupsDTO groupsDTO);
		GroupsDTO getGroupInfoByGno(String gno);
	}
