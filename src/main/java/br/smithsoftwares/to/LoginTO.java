package br.smithsoftwares.to;

import java.io.Serializable;

public class LoginTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String mail;
	private String pass;

	public LoginTO() {
	}

	public LoginTO(String mail, String pass) {
		super();
		this.mail = mail;
		this.pass = pass;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Contact [mail=" + mail + ", pass=" + pass + "]";
	}
	
}
