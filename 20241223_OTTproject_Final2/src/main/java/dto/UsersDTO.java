package dto;

public class UsersDTO {
    private String id;
    private String name;
    private String email;
    private String birth; // 생년월일
    private String password;
    private String account;
    private String profileImg; // 프로필 이미지 경로

    // 기본 생성자
    public UsersDTO() {
        this.birth = "1980-01-01"; // 기본값 설정
    }

    // 매개변수 생성자
    public UsersDTO(String id, String name, String email, String birth, String password, String account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = (birth == null || birth.isEmpty()) ? "1980-01-01" : birth; // 기본값 처리
        this.password = password;
        this.account = account;
    }

    // Getter와 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = (birth == null || birth.isEmpty()) ? "1980-01-01" : birth; // 기본값 처리
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    // 유효성 검사 메서드
    public boolean isValid() {
        return id != null && !id.isEmpty() &&
               name != null && !name.isEmpty() &&
               email != null && !email.isEmpty() &&
               password != null && !password.isEmpty();
    }

    @Override
    public String toString() {
        return "UsersDTO{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", birth='" + birth + '\'' +
               ", password='" + password + '\'' +
               ", account='" + account + '\'' +
               ", profileImg='" + profileImg + '\'' +
               '}';
    }
}
