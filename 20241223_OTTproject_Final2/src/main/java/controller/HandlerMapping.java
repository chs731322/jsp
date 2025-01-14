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
    		case "profileImgUpdate":
    			controller = new ProfileImgController();
    			break;
    		case "deleteProfileImg":
    			controller = new DeleteProfileImgController();
    			break;
    		case "insertgroupmember":
    			controller = new insertgroupmemberController();
    			break;
    		case "updatePayment":
    			controller = new UpdatePaymentController();
    			break;
    		case "ott_view":
    			controller = new OttViewController();
    			break;
    		case "insertGroupAndPost":
    			controller = new InsertGroupAndPostController();
    			break;
    		case "deleteGroupAndPost":
    			controller = new deleteGroupAndPostController();
    			break;
    		case "postlistview":
    			controller = new postlistviewController();
    			break;
    		case "insertpost":
    			controller = new insertpostviewController();
    			break;
    		case "timer":
    			controller = new timerController();
    			break;
        }
        return controller;
    }
}
