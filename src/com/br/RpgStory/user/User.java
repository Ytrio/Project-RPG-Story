package com.br.RpgStory.user;

/*Manipula o usuário*/
public class User {
	
	/* Membros privados de acesso restrito */
	private String user;
	private String password;
	private String email;
	private String dataNascimento;

	/*Obtem o nome do usuário*/
	public void setUser(String user) {
		this.user = user;
	}

	/*Retorna o nome do usuário*/
	public String getUser() {
		return this.user;
	}
	
	/*Obtem o password do usuário*/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*Retorna o password do usuário*/
	public String getPassword() {
		return this.password;
	}

	/*Retorna o email do usuário*/
	public String getEmail() {
		return email;
	}

	/*Obtem o email do usuário*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*Retorna a data de nascimento do usuário*/
	public String getDataNascimento() {
		return dataNascimento;
	}

	/*Obtem a data de nascimento do usuário*/
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
