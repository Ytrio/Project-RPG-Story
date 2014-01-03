package com.br.RpgStory.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppMainAluno extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String[] vetorName = { "InputMatAluno", "InputNomeAluno",
				"InputEndAluno", "InputCepAluno", "InputCidadeAluno",
				"InputBairroAluno" };

		String[] nomes = { "Matricula aluno: ", "Nome do aluno: ",
				"Endereço do aluno: ", "Cep do aluno: ", "Cidade do aluno: ",
				"Bairro do Aluno:" };

		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<br/><br/>");
		out.print("<h1 style='text-align:center'>Dados do aluno cadastrado</h1>");

		if (!req.getParameter(vetorName[0]).equals("")
				&& !req.getParameter(vetorName[1]).equals(" ")
				&& !req.getParameter(vetorName[2]).equals(" ")
				&& !req.getParameter(vetorName[3]).equals(" ")
				&& !req.getParameter(vetorName[4]).equals(" ")
				&& !req.getParameter(vetorName[5]).equals(" ")) {
			
			for (int index = 0; index < vetorName.length; index++) {
				vetorName[index] = req.getParameter(vetorName[index]);
				out.print("<span>" + nomes[index] + "</span>"
						+ vetorName[index] + "<br/>");
			}
			out.print("</body>");
			out.print("</html>");
		} else {
			resp.sendRedirect("WhitePage.html");
		}

		out.close();
	}

}
