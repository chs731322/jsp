package dto;

public class GroupsDTO {
	private String gno;
	private String platformnum;
	private String ott_id;
	private String ott_password;

public GroupsDTO() { }

public GroupsDTO(String gno, String platformnum, String ott_id, String ott_password) {
	super();
	this.gno = gno;
	this.platformnum = platformnum;
	this.ott_id = ott_id;
	this.ott_password = ott_password;
}

public String getGno() {
	return gno;
}

public void setGno(String gno) {
	this.gno = gno;
}

public String getPlatformnum() {
	return platformnum;
}

public void setPlatformnum(String platformnum) {
	this.platformnum = platformnum;
}

public String getOtt_id() {
	return ott_id;
}

public void setOtt_id(String ott_id) {
	this.ott_id = ott_id;
}

public String getOtt_password() {
	return ott_password;
}

public void setOtt_password(String ott_password) {
	this.ott_password = ott_password;
}


}