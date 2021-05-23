package  com.example.goodpizzagreatpizza.ui.login;
import java.util.ArrayList;

public class UserDBAccess {
	static ArrayList<String[]> userDB = new ArrayList<String[]>(); //id, pw, name, address, phonenum
	
	UserDBAccess(){
		userDB.add(new String[]{"ws123", "abc123", "임우섭", "서울", "010-1234-5678"});
		userDB.add(new String[]{"yh123", "cba123", "김용환", "경기도", "010-2345-6789"});
		userDB.add(new String[]{"jh123", "bca123", "서정현", "대전", "010-3456-7890"});
		userDB.add(new String[]{"tg123", "cab123", "한태균", "남양주", "010-4567-8901"});
		userDB.add(new String[]{"sw123", "def123", "정석우", "천안", "010-5678-9012"});
		userDB.add(new String[]{"js123", "efd123", "한정수", "광주", "010-6789-0123"});
		userDB.add(new String[]{"cm123", "god123", "이창민", "하늘", "010-7890-1234"});
	}
	
	public boolean find(Token t) {
		for(String[] arr : userDB) {
			if(arr[0].equals(t.id)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean add(String id, String pw, String name, String address, String phonenum) {
		userDB.add(new String[] {id, pw, name, address, phonenum});
		
		return true;
	}
	
	public Profile auth(Token t) {
		for(String[] arr : userDB) {
			if(arr[0].equals(t.id)) {
				if(arr[1].equals(t.pw)) {
					return new Profile(new Token(arr[0], arr[1]), arr[2], arr[3], arr[4]);
				}
				else {
					return null;
				}
			}
		}
		return null;
	}

	public String test(){
		return userDB.get(0)[0];
	}
}
