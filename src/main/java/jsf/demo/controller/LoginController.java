package jsf.demo.controller;

import java.io.Serializable;
import java.util.Iterator;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
			FacesMessage msg = new FacesMessage("Username and password must not be the same");
			FacesContext context = FacesContext.getCurrentInstance();
			UIComponent msgComponent = findComponent(context.getViewRoot(), "txtPassword");
			context.addMessage(msgComponent.getClientId(context), msg);
			context.renderResponse();
		}
	}

	public void renderResponse() {
		LOG.info("value change listener called!");
		FacesContext.getCurrentInstance().renderResponse();
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

	private UIComponent findComponent(UIComponent c, String id) {
		if (id.equals(c.getId())) {
			return c;
		}
		Iterator<UIComponent> kids = c.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent found = findComponent(kids.next(), id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
}
