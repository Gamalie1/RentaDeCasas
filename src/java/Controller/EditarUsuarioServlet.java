/*
Autor: Gamaliel Silva Lopez 
Fecha creación: 17/03/2022
Fecha actualización: 22/03/2022
Descripción: Servlet para editar usuario
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

public class EditarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int idUsuario= Integer.parseInt(request.getParameter("idUsuario"));
        IUsuarioService service = new UsuarioServiceImpl();
        Usuario usuario = new Usuario();
        usuario = service.obtenerRegistro(idUsuario);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<link rel='stylesheet' href='"+request.getContextPath()+"/Resources/CSS/EstiloEditarUsuario.css'>");
        
        out.println("</head>");
        out.println("<body>");
        out.println("<section class=\"forma\">");
       
        out.println("<form action='GuardarEditarUsuarioServlet' method='GET'>");
        
        out.println("<input type='hidden' name='idUsuario' class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" value='"+usuario.getCodigo()+"'><br>");
        out.println("<div id=\"form-main\">");
        out.println("<div id=\"form-div\">");
        out.println("<form class=\"form\" id=\"form1\">");

     
     out.println("<p class=\"name\">"); 
               out.println("<input type='text' name='nombre' class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" value='"+usuario.getNombre()+"' required pattern=\"[A-Za-z]{1,}\" title=\"Porfavor escribir solo letras\"><br>");
                 
                         out.println("</p>");
      
        
        out.println("<p class=\"name\">"); 
               
                 out.println("<input type='text' name='usuario' class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" value='"+usuario.getNombre_Usuario()+"' required pattern=\"[A-Za-z]{1,}\" title=\"Porfavor escribir solo letras\"><br>");
                         out.println("</p>");
      
        
        out.println("<p class=\"name\">"); 
              
                 out.println("<input type='password' class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" name='contraseña' value='"+usuario.getContraseña()+"'><br>");
                         out.println("</p>");
                         
                           out.println("<p class=\"name\">"); 
               out.println("<input type='number' min='1' name='edad' class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" value='"+usuario.getEdad()+"' required><br>");
                         out.println("</p>");
                         
                                  out.println("<p class=\"name\">"); 
              out.println("<input type='text' name='sexo' class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" value='"+usuario.getSexo()+"'><br>");
                         out.println("</p>");
                         
      
         
        
        
      
    

    
       out.println(" <div class=\"submit\">");
        
        out.println("<input type=\"submit\" value=\"Guardar\" id=\"button-blue\"/>");
        
       out.println("<div class=\"ease\"></div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        
        out.println("</body>");
        out.println("</html>");
        
    }
}
