/*
Autor: Jesús Fernando Hernández Vite
Fecha creación: 17/03/2022
Fecha actualización: 17/03/2022
Descripción: Servlet para listar usuarios
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

public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
       
        out.println("<head>");
       out.println("<link rel='stylesheet' href='" + request.getContextPath() + "/Resources/CSS/StyleForm.css'>");
       out.println("<script type='text/javascript' src='./javascript.js\'></script>");
        out.println("</head>");
        out.println("<body>");
   
        out.println("<div id=\"main-container\">");
        out.println("<table>");
        out.println("<div id=\"main-container\">");
        out.println("<thead>");
        out.println("<th>Codigo</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Contraseña</th>");
        out.println("<th>Usuario</th>");
        out.println("<th>Edad</th>");
        out.println("<th>Sexo</th>");
        out.println("<th>Editar</th>");
        out.println("<th>Eliminar</th>");
        out.println("</thead>");
        IUsuarioService service = new UsuarioServiceImpl();
        List<Usuario> listaUsuario = service.obtenerRegistros();
        out.println("<tbody>");
        for (Usuario usuario : listaUsuario){
            out.println("<tr>");
            out.println("<td>"+usuario.getCodigo()+"</td>");
            out.println("<td>"+usuario.getNombre()+"</td>");
            out.println("<td>"+usuario.getContraseña()+"</td>");
            out.println("<td>"+usuario.getNombre_Usuario()+"</td>");
            out.println("<td>"+usuario.getEdad()+"</td>");
            out.println("<td>"+usuario.getSexo()+"</td>");
            out.println("<td><a href='EditarUsuarioServlet?idUsuario="+usuario.getCodigo()+"'>Editar</a></td>");
           
             out.println("<td><a href='EliminarUsuarioServlet?idUsuario=" + usuario.getCodigo() + "'    onclick=\"return confirm('Estás seguro que deseas eliminar el registro?');\" >Eliminar</a></td>");
        }
        
        out.println("</table>");
         out.println("</div>");

        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
		
			
				
	
        
   
    }

}
