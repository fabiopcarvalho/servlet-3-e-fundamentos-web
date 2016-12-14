package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.*;

public class NovaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest request,
            HttpServletResponse response) {

        String nome = request.getParameter("nome");

        Empresa empresa = new Empresa(nome);
        new EmpresaDAO().adiciona(empresa);

        request.setAttribute("nome", nome);

        return "/WEB-INF/paginas/novaEmpresa.jsp";

    }

}

//@WebServlet(urlPatterns="/novaEmpresa")
//public class NovaEmpresa extends HttpServlet{
//	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//		String nome = req.getParameter("nome");
//		
//		Empresa empresa = new Empresa(nome);
//	    new EmpresaDAO().adiciona(empresa);
//	    
//	    req.setAttribute("nome", nome);
//
//	    RequestDispatcher dispatcher = req
//	            .getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
//	    dispatcher.forward(req, resp);
//	}
//	 
//}
