package service;

import java.util.List;

import config.DBManager;
import dto.GroupsDTO;
import mapper.GroupsMapper;

public class GroupsService {
	private GroupsMapper groupsMapper;

	private static GroupsService instance = new  GroupsService();
	
	private GroupsService() {	
		groupsMapper = DBManager.getInstance().getSession().getMapper(GroupsMapper.class);
	}

	
	public static GroupsService getInstance() {
		if(instance == null)
			instance = new GroupsService();
		return instance;
	}
	
	public int insertgroups(GroupsDTO groupsDto) {
		return groupsMapper.insertGroups(groupsDto);
	}
	
	
	public List<GroupsDTO> getgroupsItem() {
		return groupsMapper.getGroupsItem();
	}
	
	public List<GroupsDTO> getgroupslist(GroupsDTO groupsDTO) {
		return groupsMapper.getGroupslist(groupsDTO);
	}
	
	public int deletegroups(GroupsDTO groupsDto) {
		return groupsMapper.deleteGroups(groupsDto);
	}


	public GroupsDTO getGroupsInfo(GroupsDTO groupsDTO) {
		return groupsMapper.getGroupsInfo(groupsDTO);
	}


	public GroupsDTO getGroupInfoByGno(String gno) {
		return groupsMapper.getGroupInfoByGno(gno);
	}

}

