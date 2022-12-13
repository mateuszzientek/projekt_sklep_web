package com.jsfcourse.login;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.simplesecurity.RemoteClient;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LoginBB {
	private static final String PAGE_MAIN = "/public/index";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String login;
	private String haslo;
	private String mateusz= "mateusz";
	private String mati= "mati";
	
	@Inject
	FacesContext ctx;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}


	public String doLogin() {
		
		if (login.equals("mateusz")&& haslo.equals("mati")) { 
			   return "/pages/home/home";
			}else {
				ctx.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nie poprawny login lub hasło", null));
				return null;
			}
	}
		
		
	public String doLogout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();
		return "/public/index";
	}
	
}
