package com.br.RpgStory.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.br.RpgStory.user.User;
import com.br.RpgStory.user.UserDAO;

public class ApplicationMain_UserRegister extends HttpServlet {

 public String userName,userPass,user_email,userDate;
 
 
	/*Servlet UserRegister*/
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		boolean isbool = ServletFileUpload.isMultipartContent(req);
		
		
		/*Atributos do usuário */
		userName   = req.getParameter("InputUserName");
		userPass   = req.getParameter("InputPassword");
		user_email = req.getParameter("email");
		userDate   = req.getParameter("data");
		
		
		/* Cria uma instância do objeto usuário */
		User user = new User();

		/* Passa o nome do usuário e sua senha */
		user.setUser(userName);
		user.setPassword(userPass);
		user.setEmail(user_email);
		user.setDataNascimento(userDate);
		
		/* Cria um instância do objeto DAO */
		UserDAO dao = new UserDAO();

		try {
			String usuario = " ";
			Connection con =  dao.getConnect();
			PreparedStatement sendSQL = con.prepareStatement("select nome from login where nome = ?");
				
			/* Seleciona o usuário */
			sendSQL.setString(1,user.getUser());
			// Retorna todos os registro de um dad
			ResultSet rs = sendSQL.executeQuery();
			
			while (rs.next()) usuario = rs.getString("nome");
			dao.userVerific(usuario, user, req, resp);
			


			rs.close(); // Fecha o ResultSet
			con.close(); // Fecha a conexão
			sendSQL.close(); // Fecha o stat

			/* Fecha a conexão */

		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
		dao.closeConnection(dao.getConnect());
	}

}
