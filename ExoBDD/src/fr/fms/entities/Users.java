package fr.fms.entities;

public class Users {

	private int IdUSer;
	private String login;
	private String password;

	public Users(int IdUSer, String login, String password) {
		this.IdUSer = IdUSer;
		this.login = login;
		this.password = password;
	}
	// Getters Setters
	public int getIdUSer() {
		return IdUSer;
	}
	public void setIdUSer(int idUSer) {
		IdUSer = idUSer;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
