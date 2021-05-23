
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
	
	public String sign_in(String id, String pw) {	//�α���
		
		/*
		 * 	Success : ����
		 * 	Wrong Input : �߸��� ���̵� or ��й�ȣ
		 * 	Signin Failed : �α��� �� ���� �߻�
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
	
	public String sign_up(String id, String pw, String name, String address, String phonenum) {	//ȸ������
		
		/*
		 * 	Succes : ȸ������ ����
		 * 	Already Exist : �̹� ���̵� ����
		 * 	Signup Failed : ȸ������ �� ����
		 * 
		 */
		
		
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
