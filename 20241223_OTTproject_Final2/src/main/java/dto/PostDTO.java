package dto;

public class PostDTO {

    private String title;         // 글 제목
    private String content;       // 글 내용
    private String postNum;       // 게시글 번호
    private String platformNum;   // 플랫폼 번호
    private String id;            // 작성자 ID
    private String postDate;      // 게시글 작성일
    private String postData;      // 게시글 데이터
    private int nowNum;       // 현재 그룹 인원 수
    private String shareNum;      // 공유 인원 수
    private String ottpassword;   // OTT 비밀번호
    private String ottid;
    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for postNum
    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    // Getter and Setter for platformNum
    public String getPlatformNum() {
        return platformNum;
    }

    public void setPlatformNum(String platformNum) {
        this.platformNum = platformNum;
    }

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for postDate
    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    // Getter and Setter for postData
    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    // Getter and Setter for shareNum
    public String getShareNum() {
        return shareNum;
    }

    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }

    // Getter and Setter for ottpassword
    public String getOttpassword() {
        return ottpassword;
    }

    public void setOttpassword(String ottpassword) {
        this.ottpassword = ottpassword;
    }

	public int getNowNum() {
		return nowNum;
	}

	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}
	
	 public String getOttid() {
	        return ottid;
	    }

	    public void setOttid(String ottid) {
	        this.ottid = ottid;
	    }
}
