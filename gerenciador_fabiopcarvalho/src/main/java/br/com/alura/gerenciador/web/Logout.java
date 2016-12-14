package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa {

    @Override
    public String executa(HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.removeAttribute("usuarioLogado");

        return "/WEB-INF/paginas/logout.html";

    }
}

//@WebServlet(urlPatterns = "/logout")
//public class Logout extends HttpServlet {
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//	        throws ServletException, IOException {
//
//	    HttpSession session = req.getSession();
//	    session.removeAttribute("usuarioLogado");
//
//	    RequestDispatcher dispatcher = req
//	            .getRequestDispatcher("/WEB-INF/paginas/logout.html");
//	    dispatcher.forward(req, resp);
//
//	}
//
////	@Override
////	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
////	        throws ServletException, IOException {
////
////	    HttpSession session = req.getSession();
////
////	    session.removeAttribute("usuario.logado");
////	    //session.invalidate();  //serve também para apagar esse 'cookie'
////
////	    PrintWriter writer = resp.getWriter();
////	    writer.println("<html><body>Logout efetuado</body></html>");
////	}
//}