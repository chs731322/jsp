package controller;


public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "userUpdate":
			controller = new UserInfoUpdateController();
			break;
		case "userDelete":
			controller = new UserInfoDeleteController();
			break;
		case "groupView":
			controller = new GroupViewController();
			break;
		}
		
		return controller;
	}

	
	
}