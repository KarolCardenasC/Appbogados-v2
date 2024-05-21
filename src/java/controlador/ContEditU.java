package controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ContEditU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener el parámetro de acción de la solicitud
        String action = request.getParameter("action");

        // Realizar la acción correspondiente
        if ("buscar".equals(action)) {
            // Realizar la búsqueda del usuario
            buscarUsuario(request, response);
        } else if ("actualizar".equals(action)) {
            // Actualizar el usuario
            actualizarUsuario(request, response);
        }
    }

    // Método para buscar usuario por ID
    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el ID de usuario de la solicitud
        String idUsuario = request.getParameter("idUsu");

        // Realizar la búsqueda del usuario por su ID
        Usuario usuario = UsuarioDAO.obtenerUsuarioPorId(idUsuario);

        // Establecer el atributo de usuario en el request para mostrar en la vista
        request.setAttribute("usuario", usuario);

        // Redirigir a la página de resultados de búsqueda
        request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
    }

    // Método para actualizar usuario
     private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String idUsuario = request.getParameter("idUsuario");
        String nomUsu = request.getParameter("nomUsu");
        String apeUsu = request.getParameter("apeUsu");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        int idTipoUsu = Integer.parseInt(request.getParameter("idTipoUsu"));

        // Crear objeto de Usuario con los datos actualizados
        Usuario usuario = new Usuario(idUsuario, null, null, nomUsu, apeUsu, email, telefono, direccion, idTipoUsu);

        // Actualizar usuario en la base de datos
        int status = UsuarioDAO.actualizarUsuario(usuario);

        // Redirigir a una página de confirmación
        response.sendRedirect("mensaje.jsp"); // Cambiar al nombre de tu página de confirmación
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
