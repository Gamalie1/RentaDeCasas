/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EliminarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  response.setContentType("text/html");
        PrintWriter out = response.getWriter();//Enviar datos al cliente
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("</head>");
        out.println("<body>");

        out.println("<table>");

        out.println("<tr>");

        out.println("<th> id </th>");
       
        out.println("<th> nombre </th>");
       
        out.println("<th> contraseña </th>");
     
        out.println("</tr>");
        
        out.println("<tbody>");
        IUsuarioService service = new UsuarioServiceImpl();
        
        List<Usuario> listausuario = service.obtenerREgistros();

        for(Usuario usr: listausuario){
            out.println("<tr>");
                out.println("<td>"+usr.getCodigo()+"</td>");
                out.println("<td>"+usr.getNombreUsuario()+"</td>");
                out.println("<td>"+usr.getContraseña()+"</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}
