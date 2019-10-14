package jsf.demo.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AdNovum Informatik AG
 */
@Named
@RequestScoped
public class LoginController {

	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	private String username;

	private String password;

	public void getUserInfo() {
		LOG.info("Username = " + username + " &&& Password = " + password);
	}

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
