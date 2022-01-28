
public class User {
	protected String userName;
	protected String password;
	protected String role;
	protected int status;

	public User(String userName, String password, String role,int status) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.status = status;

	}

	// get and set
	public String getuserName() {
		return userName;
	}

	public String getpassword() {
		return password;
	}

	public String getrole() {
		return role;
	}
	public int getstatus() {
		return status;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public void setrole(String role) {
		this.role = role;
	}
	public void setstatus(int status) {
		this.status = status;
	}

}
