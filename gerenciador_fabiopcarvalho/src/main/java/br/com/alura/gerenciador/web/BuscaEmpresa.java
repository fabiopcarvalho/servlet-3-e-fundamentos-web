package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.*;

public class BuscaEmpresa implements Tarefa {

    public BuscaEmpresa() {
        System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa "
                + this);
    }

    @Override
    public String executa(HttpServletRequest request,
            HttpServletResponse response) {

        String filtro = request.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDAO()
                .buscaPorSimilaridade(filtro);

        request.setAttribute("empresas", empresas);

        return "/WEB-INF/paginas/buscaEmpresa.jsp";

    }

}

//@WebServlet(urlPatterns = "/busca")
//public class BuscaEmpresa extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//    	
//    	String filtro = req.getParameter("filtro");
//        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
//        req.setAttribute("empresas", empresas);
//
//        RequestDispatcher dispatcher = req
//                .getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
//        dispatcher.forward(req, resp);
//
////        PrintWriter writer = resp.getWriter();
////        writer.println("<html>");
////        writer.println("<body>");
////        writer.println("Resultado da busca:<br/>");
////        
////        writer.println("<ul>");
////        for(Empresa empresa : empresas) {
////            writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
////        }
////        writer.println("</ul>");
////        
////        writer.println("</body>");
////        writer.println("</html>");
//    }
//
//}
