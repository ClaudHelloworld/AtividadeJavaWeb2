/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claud
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/math.html"})
public class MathServlet extends HttpServlet {

      /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String error = null;
            double n1=1, n2=1;
            try{
                String p1 = request.getParameter("n1");
                String p2 = request.getParameter("n2");

                n1 = Double.parseDouble(p1);
                n2 = Double.parseDouble(p2);
            }catch(Exception e){
                error = e.getMessage();
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Números aleatórios - JavaEE</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.println("<h1>JavaEE</h1>");
            out.println("<h2>Operação</h2>");
            if(error != null){
                out.println("<span style='color:red'>Erro ao tentar ler parâmetros</span>");
            }else{
                String p = request.getParameter("operador");
                switch (p) { 
                    case "+": 
												out.println("<div>");
                        out.println(n1+" + "+n2+" = "+(n1+n2));
                        out.println("</div>");
												break; 
                    case "-": 
												out.println("<div>");
                        out.println(n1+" - "+n2+" = "+(n1-n2));
                        out.println("</div>");
												break; 
                    case "*": 
												out.println("<div>");
                        out.println(n1+" * "+n2+" = "+(n1*n2));
                        out.println("</div>"); 
												break; 
                    case "/":
                        if (n1 == 0.0 || n2 == 0.0){
                            out.println("<div>");
                            out.println("<h3>Não é possível dividir por zero</h3>");
                            out.println("</div>"); 
                        }
                        else {
                            out.println("<div>");
                            out.println(n1+" / "+n2+" = "+(n1/n2));
                            out.println("</div>");
                        }
												break;  
									} 
		        }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}