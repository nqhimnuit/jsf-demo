package jsf.demo.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author AdNovum Informatik AG
 */
@Named
@RequestScoped
public class LoginController {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
