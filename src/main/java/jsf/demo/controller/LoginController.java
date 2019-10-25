package jsf.demo.controller;

import java.io.Serializable;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
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
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	private String username;

	private String password;

	public String getUsername() {
		LOG.info("getting username = {}", username);
		return username;
	}

	public void setUsername(String username) {
		LOG.info("setting username = {}", username);
		this.username = username;
	}

	public String getPassword() {
		LOG.info("getting password = {}", password);
		return password;
	}

	public void setPassword(String password) {
		LOG.info("setting password = {}", password);
		this.password = password;
	}

	public void checkUserInfo() throws Exception {
		LOG.info("checking for user info...");
		if (username.equals(password)) {
			addErrorToMessage("Username and password must not be the same");
			resetInput();
		}
		LOG.info("done >>> checking for user info");
	}

	public void customEventHandler() {
		LOG.info("value change listener called!");
		FacesContext.getCurrentInstance().responseComplete();
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

	private void addErrorToMessage(String errorMsg) {
		FacesMessage msg = new FacesMessage(errorMsg);
		FacesContext context = FacesContext.getCurrentInstance();
		UIComponent msgComponent = findComponent(context.getViewRoot(), "txtPassword");
		context.addMessage(msgComponent.getClientId(context), msg);
		context.validationFailed();
	}

	private void resetInput() {
		username = "";
		password = "";
	}
}
