/*
 Autor: Gamaliel Silva Lopez
 Fecha de creacion: 11 de marzo de 2022
 Fecha de modificacion: 16 de marzo de 2022
 Descripcion: Se crea una clase de tipo servlet enfocada hacia el usuario.
 */
package Controller;

import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import entity.Usuario;
import java.util.List;

public class ListarUsuarioServlet extends HttpServlet {


    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Contraseña</th>");
        out.println("</tr>");
        IUsuarioService service=new UsuarioServiceImpl();
         Usuario u1 = new Usuario();
         List<Usuario> listausuario=service.obtenerREgistros();
           out.println("<tbody>");
        for (Usuario usr:listausuario) {
                    out.println("<td>"+u1.getCodigo()+"</td>");
                    out.println("<td>"+u1.getNombreUsuario()+"</td>");
                    out.println("<td>"+u1.getContraseña()+"</td>");
                          
            
        }
         out.println("</tbody>");
        
        out.println("</table>");

        out.println("</head>");
        out.println("</html>");
        
    }

}
