package mainPackage;

public class DataFR {
	private int _id;
	private String password, gender, birthDate, firstName, lastName, email, error;
	
	public DataFR() {}
	public DataFR(int _id, String password, String gender, String birthDate,
			String firstName, String lastName, String email, String error) {
		this._id = _id;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.error = error;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}