package controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ContBuscarU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener el ID de usuario de la solicitud
        String idUsuario = request.getParameter("idUsu");
        
        // Realizar la búsqueda del usuario por su ID
        Usuario usuario = UsuarioDAO.obtenerUsuarioPorId(idUsuario);

        // Establecer el atributo de usuario en el request para mostrar en la vista
        request.setAttribute("usuario", usuario);
        
        // Redirigir a la página de resultados de búsqueda
        request.getRequestDispatcher("buscarUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
