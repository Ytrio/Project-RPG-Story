package com.br.RpgStory.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Fabrica uma conex�o*/

public class ConnectionFactory {

	// M�todo para se conectar ao banco de dados
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());  
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root","");

		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

}
