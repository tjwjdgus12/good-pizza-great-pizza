
public class Profile {
	public Token authToken;
	public String name;
	public String address;
	public String phoneNum;
	
	public Profile(){
		
	}
	
	public Profile(Token authToken, String name, String address, String phoneNum){
		this.authToken = authToken;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}
}

