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
               out.println("<link rel='stylesheet' href='"+request.getContextPath()+"/Resources/CSS/StyleForm.css'>");

       out.println("<script type='text/javascript' src='./javascript.js\'></script>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
	out.println("<LINK REL=StyleSheet HREF=\"estilos.css\" TYPE=\"text/css\" MEDIA=screen>");
	out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">");
	out.println("<link href=\"https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap\" rel=\"stylesheet\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilohome.css\">");
        out.println("<title>RentaCasas</title>");

        out.println("</head>");
        out.println("<body>");
        out.println("<header class=\"header\">");
        out.println("<div class=\"bg-dark\">");
        out.println("<div class=\"container\">");
        out.println("<nav class=\"navbar navbar-expand-lg navbar-light\">");
            out.println("<a class=\"navbar-brand\" href=\"#\">RentaCasas</a>");
            out.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
              out.println("<span class=\"navbar-toggler-icon\"></span>");
            out.println("</button>");
            out.println("<div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">");
              out.println("<div class=\"navbar-nav w-100 justify-content-center \">");
                out.println("<a class=\"nav-item nav-link active\" href=\"/CAsas/Pages/index.html\">Inicio <span class=\"sr-only\">(current)</span></a>");
              out.println("<a class=\"nav-item nav-link\" href=\"/CAsas/Pages/crearRegistro.html\">Crear</a>");
                out.println("<a class=\"nav-item nav-link\" href=\"ListarUsuarioServlet\">Listar</a>");
                out.println("<a class=\"nav-item nav-link\" href=\"/CAsas/Pages/SobreNosotros.html\">Acerca de...</a>");
              out.println("</div>");
            out.println("</div>");
          out.println("</nav>");
        out.println("</div>");
      out.println("</div>");
    out.println("</header>");
        
        
   
        out.println("<div id=\"main-container\">");
        out.println("<table>");
        out.println("<div id=\"main-container\">");
        out.println("<thead>");
        out.println("<th>Código</th>");
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
        out.println("<footer>");
        out.println("<div class=\"Textfooter\">");
        out.println("<div class=\"container\">");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-sm-12 col-md-6 col-xl-4\">");
        out.println("<h4>Colaboradores:</h4>");
        out.println("<p class=\"TextP\">Gamaliel</p>");
        out.println("<p class=\"TextP\">Fernando Vite</p>");
        out.println("<p class=\"TextP\">Luis Lennin</p>");
        out.println("</div>");
        out.println("<div class=\"col-sm-12 col-md-6 col-xl-4\">");
        out.println("<h4>Contactos:</h4>");
        out.println("<p class=\"TextP\">Gamaliel:+52 9512323378</p>");
        out.println("<p class=\"TextP\">Fernando Vite:+52 9511602753</p>");
        out.println("<p class=\"TextP\">Lennin:+52 9531332959</p>");
        out.println("</div>");
        out.println("<div class=\"col-sm-12 col-md-6 col-xl-4\">");
        out.println("<h4>Redes Sociales</h4>");
        out.println("<p class=\"TextP\">Facebook:Renta de casas</p>");
        out.println("<p class=\"TextP\">Instagram:Renta_Casas</p>");
        out.println("<p class=\"TextP\">Twitter:@RentadeCasas</p>");
        out.println("</div> </div></div>");

        out.println("<!-- Optional JavaScript -->");
        out.println("<!-- jQuery first, then Popper.js, then Bootstrap JS -->");
        out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
        out.println("</footer>");
        out.println("</html>");
		
			
				
	
        
   
    }

}
