package mainPackage;

public class DataSE {
	private int _id;
	private String email, password, title, message, status;
	private String[] sendTo;
	public DataSE() {
		
	}
	public DataSE(int _id, String email, String password,String[] sendTo, String title, String message, String status) {
		this._id = _id;
		this.email = email;
		this.password = password;
		this.sendTo = sendTo;
		this.title = title;
		this.message = message;
		this.status = status;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String[] getSendList() {
		return sendTo;
	}
	public void setSendList(String[] sendTo) {
		this.sendTo = sendTo;
	}
}
