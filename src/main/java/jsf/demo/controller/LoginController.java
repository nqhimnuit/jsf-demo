package jsf.demo.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AdNovum Informatik AG
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	private String username;

	private String password;

	public void checkUserInfo() throws Exception {
		if (username.equals(password)) {
			throw new Exception("Username and password must not be the same");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		LOG.info("setting username = {}", username);
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		LOG.info("setting password = {}", password);
		this.password = password;
	}
}
