package com.br.RpgStory.user;

/*Manipula o usu�rio*/
public class User {
	
	/* Membros privados de acesso restrito */
	private String user;
	private String password;
	private String email;
	private String dataNascimento;

	/*Obtem o nome do usu�rio*/
	public void setUser(String user) {
		this.user = user;
	}

	/*Retorna o nome do usu�rio*/
	public String getUser() {
		return this.user;
	}
	
	/*Obtem o password do usu�rio*/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*Retorna o password do usu�rio*/
	public String getPassword() {
		return this.password;
	}

	/*Retorna o email do usu�rio*/
	public String getEmail() {
		return email;
	}

	/*Obtem o email do usu�rio*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*Retorna a data de nascimento do usu�rio*/
	public String getDataNascimento() {
		return dataNascimento;
	}

	/*Obtem a data de nascimento do usu�rio*/
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
