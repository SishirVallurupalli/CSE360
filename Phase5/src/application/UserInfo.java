package application;

public class UserInfo {
	private String userName;
	private String password;
	private String EmpCode;
	
	public UserInfo()
	{
		userName = "";
		password = "";
		EmpCode = "";
	}
	
	public UserInfo(String us, String pass, String ec)
	{
		userName = us;
		password = pass;
		EmpCode = ec;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getEmpCode()
	{
		return EmpCode;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
