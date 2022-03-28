
package Controller;

import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;




public class GuardarCrearUsuarioServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       IUsuarioService service = new UsuarioServiceImpl();
        Usuario u = new Usuario();
         u.setNombre(request.getParameter("nombre"));
        int edad= Integer.parseInt(request.getParameter("edad"));
        //u.setCodigo(request.getParameter("idUsuario"));
        u.setContraseña(request.getParameter("contraseña"));
        u.setEdad(edad);
       
        u.setNombre_Usuario(request.getParameter("usuario"));
        u.setSexo(request.getParameter("sexo"));
        service.crearRegistro(u);
        response.sendRedirect("ListarUsuarioServlet");
      
    }


}
