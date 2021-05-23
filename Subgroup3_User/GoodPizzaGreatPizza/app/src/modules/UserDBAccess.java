import java.util.ArrayList;

public class UserDBAccess {
	ArrayList<String[]> userDB = new ArrayList<String[]>(); //id, pw, name, address, phonenum
	
	UserDBAccess(){
		userDB.add(new String[]{"ws123", "abc123", "�ӿ켷", "����", "010-1234-5678"});
		userDB.add(new String[]{"yh123", "cba123", "���ȯ", "��⵵", "010-2345-6789"});
		userDB.add(new String[]{"jh123", "bca123", "������", "����", "010-3456-7890"});
		userDB.add(new String[]{"tg123", "cab123", "���±�", "������", "010-4567-8901"});
		userDB.add(new String[]{"sw123", "def123", "������", "õ��", "010-5678-9012"});
		userDB.add(new String[]{"js123", "efd123", "������", "����", "010-6789-0123"});
		userDB.add(new String[]{"cm123", "god123", "��â��", "�ϴ�", "010-7890-1234"});
	}
	
	public boolean find(Token t) {	//���̵� �ִ��� ã��
		for(String[] arr : userDB) {
			if(arr[0] == t.id) {
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
			if(arr[0] == t.id) {
				if(arr[1] == t.pw) {
					return new Profile(new Token(arr[0], arr[1]), arr[2], arr[3], arr[4]);
				}
				else {
					return null;
				}
			}
		}
		return null;
	}
}
