
public class SignController {
	
	UserDBAccess DB;
	LoginManager loginManager;
	
	public SignController() {
		DB = new UserDBAccess();
		loginManager = new LoginManager();
	}
	
	public int test() {
		return 1;
	}
	
	public String sign_in(String id, String pw) {	//로그인
		
		/*
		 * 	Success : 성공
		 * 	Wrong Input : 잘못된 아이디 or 비밀번호
		 * 	Signin Failed : 로그인 중 버그 발생
		 *
		 */
		
		
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
	
	public String sign_up(String id, String pw) {	//회원가입
		
		/*
		 * 	Succes : 회원가입 성공
		 * 	Already Exist : 이미 아이디가 있음
		 * 	Signup Failed : 회원가입 중 실패
		 * 
		 */
		
		
		Token t = new Token(id, pw);
		if(DB.find(t)) {
			return "Already Exist";
		}
		if(DB.add(t)) {
			return "Success";
		} else {
			return "Signup Failed";
		}
	}
}
