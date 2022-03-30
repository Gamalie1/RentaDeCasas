/*
Autor: Gamaliel Silva Lopez 
Fecha creación: 17/03/2022
Fecha actualización: 17/03/2022
Descripción: Servlet para eliminar usuarios
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

public class EliminarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario= Integer.parseInt(request.getParameter("idUsuario"));
        IUsuarioService service = new UsuarioServiceImpl();
        service.eliminarRegistro(idUsuario);
        response.sendRedirect("ListarUsuarioServlet");
    }
}
