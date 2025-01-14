package dto;

import java.time.LocalDateTime;

public class GroupMemberDTO {
    private String gno;
    private String platformNum;
    private String id;
    private int payment;

    // OTT 정보 필드 추가
    private String ottId;
    private String ottPassword;
    private LocalDateTime createdDate; // 추가된 필드
   
    // Getter and Setter for createdDate
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    // Getter와 Setter
    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public String getPlatformNum() {
        return platformNum;
    }

    public void setPlatformNum(String platformNum) {
        this.platformNum = platformNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getOttId() {
        return ottId;
    }

    public void setOttId(String ottId) {
        this.ottId = ottId;
    }

    public String getOttPassword() {
        return ottPassword;
    }

    public void setOttPassword(String ottPassword) {
        this.ottPassword = ottPassword;
    }
}
