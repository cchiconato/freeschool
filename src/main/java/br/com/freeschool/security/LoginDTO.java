package br.com.freeschool.security;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginDTO {

	@NotBlank
	@Email
	private String login;
	@NotBlank
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "LoginDTO [login=" + login + ", senha=" + senha + "]";
	}
	
	

}
