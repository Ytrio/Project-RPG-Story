package com.br.RpgStory.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.RpgStory.bd.ConnectionFactory;

public class UserDAO {

	/* Vari�vel privada! */
	private Connection connection;

	/* Cria uma conex�o ao criar um inst�ncia da classe UserDAO */
	public UserDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/* Deleta o usu�rio de acordo com o seu ID */
	public void delete(int id) {
		/* Deleta o usu�rio especificado */
		String deleterUser = "delete from login where id= ?";
		try {
			PreparedStatement SQLDelete = connection
					.prepareStatement(deleterUser);
			SQLDelete.setInt(1, id);
			SQLDelete.execute();
			SQLDelete.close();
			connection.close();
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	/* Adiciona um novo usu�rio ao banco de dados */
	public void addUserDB(User user) {
		System.out.println(user.getUser());
		String sql = "insert into login (nome,senha) Values(?,?) ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUser());
			stmt.setString(2, user.getPassword());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	/* Fecha a conex�o do banco de dados */
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	/* Verifica se o nome do usu�rio est� dispon�vel */
	public boolean userVerific(String usuario, User user,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// verifica se o usu�rio j� existe no Banco de dados;
		if (usuario.equals(user.getUser())) {
			req.setAttribute("username", user.getUser() + " est� indispon�vel");
			RequestDispatcher path = req
					.getRequestDispatcher("/UserRegister.jsp");
			path.forward(req, resp);
			return false;
		} else {
			/* Adiciona a banco de dados e redireciona para p�gina de login */
			addUserDB(user);
			resp.sendRedirect("UserLogin.jsp");
		}

		return true;
	}

	/* Verifica se o usu�rio e a senha est�o corretos */
	public boolean login(String usuario, String userPass, User user,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {

		/* Verifica se o usu�rio e a senha est�o registrados na base de dados */
		if (usuario.equals(user.getUser()) && userPass.equals(user.getPassword())) {
			    HttpSession session = req.getSession();
			    session.setMaxInactiveInterval(10); 
			    session.setAttribute("name",user.getUser());
			    req.getRequestDispatcher("/WelcomePage.jsp").forward(req,resp);
			    return true;
		}
		
		/*Seleciona um usu�rio especifico na base de dados*/
		String SQL_Select_Name = "select nome from login where nome = ?";
		try {
			
			/*Envia os parametros SQL para a base de dados*/	
			PreparedStatement ps = connection.prepareStatement(SQL_Select_Name);
			ps.setString(1,user.getUser());
			ResultSet resultSet = ps.executeQuery();
		
		/*Retorna a coluna especifica de acordo com query enviada para o banco de dados*/
		while(resultSet.next())
		usuario = resultSet.getString("nome");
				
		/*Verifica se a senha digitada � v�lida*/
		if ((usuario.equals(user.getUser()) && (userPass != user.getPassword() ||user.getPassword() == ""))) {
			  /* Envia para a p�gina de registro */
				req.setAttribute("login", "Password Invalid");
		}
		
		/*verifica se o usu�rio est� cadastrado na base de dados*/
		if(!usuario.equals(user.getUser())){
			/* Envia para a p�gina de registro */
			req.setAttribute("login","not registered");
			req.setAttribute("name",user.getUser());
		}
		
		/*Fecha o Objeto PreparedStatement & ResultSet*/
		ps.close();
		resultSet.close();
		} catch(SQLException exception){
			exception.getCause();
		} 

		//Fecha a conex�o com a base de dados
		closeConnection(getConnect());
		
		//Direciona para p�gina
		RequestDispatcher path = req.getRequestDispatcher("/UserLogin.jsp");
		path.forward(req,resp);
		
		return true;
	}

	/* Chama a Conex�o */
	public Connection getConnect() {
		return this.connection;
	}

}
