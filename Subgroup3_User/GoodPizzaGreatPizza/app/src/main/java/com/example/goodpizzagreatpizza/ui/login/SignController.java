package  com.example.goodpizzagreatpizza.ui.login;
public class SignController {
	
	static private UserDBAccess DB;
	static private LoginManager loginManager;
	
	public SignController() {
		if(DB == null)
			DB = new UserDBAccess();
		if(loginManager == null)
			loginManager = new LoginManager();
	}
	
	public int test() {
		return 1;
	}
	
	public String sign_in(String id, String pw) {
		
		
		Token t = new Token(id, pw);
		Profile p = DB.auth(t);
		if(p == null) {
			return "Wrong Input";
		}
		
		if(loginManager.login_request(p)) {
			return "Success";
		} else {
			return "Signin Failed";
		}
		
	}
	
	public String sign_up(String id, String pw, String name, String address, String phonenum){
		
		
		Token t = new Token(id, pw);

		if(DB.find(t)) {
			return "Already Exist";
		}
		if(DB.add(id, pw, name, address, phonenum)) {
			return "Success";
		} else {
			return "Signup Failed";
		}

	}
}
