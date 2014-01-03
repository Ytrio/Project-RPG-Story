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

	/* Variável privada! */
	private Connection connection;

	/* Cria uma conexão ao criar um instância da classe UserDAO */
	public UserDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/* Deleta o usuário de acordo com o seu ID */
	public void delete(int id) {
		/* Deleta o usuário especificado */
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

	/* Adiciona um novo usuário ao banco de dados */
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

	/* Fecha a conexão do banco de dados */
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	/* Verifica se o nome do usuário está disponível */
	public boolean userVerific(String usuario, User user,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// verifica se o usuário já existe no Banco de dados;
		if (usuario.equals(user.getUser())) {
			req.setAttribute("username", user.getUser() + " está indisponível");
			RequestDispatcher path = req
					.getRequestDispatcher("/UserRegister.jsp");
			path.forward(req, resp);
			return false;
		} else {
			/* Adiciona a banco de dados e redireciona para página de login */
			addUserDB(user);
			resp.sendRedirect("UserLogin.jsp");
		}

		return true;
	}

	/* Verifica se o usuário e a senha estão corretos */
	public boolean login(String usuario, String userPass, User user,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {

		/* Verifica se o usuário e a senha estão registrados na base de dados */
		if (usuario.equals(user.getUser()) && userPass.equals(user.getPassword())) {
			    HttpSession session = req.getSession();
			    session.setMaxInactiveInterval(10); 
			    session.setAttribute("name",user.getUser());
			    req.getRequestDispatcher("/WelcomePage.jsp").forward(req,resp);
			    return true;
		}
		
		/*Seleciona um usuário especifico na base de dados*/
		String SQL_Select_Name = "select nome from login where nome = ?";
		try {
			
			/*Envia os parametros SQL para a base de dados*/	
			PreparedStatement ps = connection.prepareStatement(SQL_Select_Name);
			ps.setString(1,user.getUser());
			ResultSet resultSet = ps.executeQuery();
		
		/*Retorna a coluna especifica de acordo com query enviada para o banco de dados*/
		while(resultSet.next())
		usuario = resultSet.getString("nome");
				
		/*Verifica se a senha digitada é válida*/
		if ((usuario.equals(user.getUser()) && (userPass != user.getPassword() ||user.getPassword() == ""))) {
			  /* Envia para a página de registro */
				req.setAttribute("login", "Password Invalid");
		}
		
		/*verifica se o usuário está cadastrado na base de dados*/
		if(!usuario.equals(user.getUser())){
			/* Envia para a página de registro */
			req.setAttribute("login","not registered");
			req.setAttribute("name",user.getUser());
		}
		
		/*Fecha o Objeto PreparedStatement & ResultSet*/
		ps.close();
		resultSet.close();
		} catch(SQLException exception){
			exception.getCause();
		} 

		//Fecha a conexão com a base de dados
		closeConnection(getConnect());
		
		//Direciona para página
		RequestDispatcher path = req.getRequestDispatcher("/UserLogin.jsp");
		path.forward(req,resp);
		
		return true;
	}

	/* Chama a Conexão */
	public Connection getConnect() {
		return this.connection;
	}

}
