package controller;

public class HandlerMapping {
    private static HandlerMapping instance = new HandlerMapping();

    private HandlerMapping() {}

    public static HandlerMapping getInstance() {
        if (instance == null)
            instance = new HandlerMapping();
        return instance;
    }

    public Controller createController(String command) {
        Controller controller = null;

        switch (command) {
            case "loginView":
                controller = new LoginViewController();
                break;
            case "login":
                controller = new LoginController();
                break;
            case "Main":
                controller = new MainController();
                break;
            case "userUpdate":
                controller = new UserInfoUpdateController();
                break;
            case "userDelete":
                controller = new UserInfoDeleteController();
                break;
            case "groupView":
                controller = new GroupViewController();
                break;
            case "mypage_view":
                controller = new MypageController();
                break;
            case "registerView": // 회원가입 페이지
                controller = new MemberInsertViewController();
                break;
            case "register": // 회원가입 처리
                controller = new MemberInsertController();
                break;
            case "logout": // 로그아웃 처리
                controller = new LogoutController();
                break;
            case "mainpage_guide": // 요금 가이드 매핑
                controller = new MainPageGuideController();
                break;
            case "checkId"://아이디 중복 처리
            	controller = new CheckedIdController();
            	break;
            case "write_post_view": 
    			controller = new writePostViewController();
    			break;
            case "write_post": 
    			controller = new writePostController();
    			break;
    		case "list_post": 
    			controller = new listPostController();
    			break;
    		case "delete_post": 
    			controller = new DeletePostController();
    			break;
    		case "profileImgUpdate":
    			controller = new ProfileImgController();
    			break;
        }
        return controller;
    }
}
