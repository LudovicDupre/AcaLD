/**
 * @author El babili - 2021
 * 
 */

package fr.fms.entities;

public class User {
	private int id;
	private String login;
	private String pwd;
	
	public User(int id, String login, String pwd) {
		this.id = id;
		this.login = login;
		this.pwd = pwd;
	}
	public User(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", pwd=" + pwd + "]";
	}	
}
