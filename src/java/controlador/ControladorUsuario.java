package controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ControladorUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idUsu;
        String usuarioLogin;
        String clave;
        String nomUsu;
        String apeUsu;
        String email;
        String telefono;
        String direccion;
        int idTipoUsu;

        idUsu = request.getParameter("cid");
        usuarioLogin = idUsu;
        clave = request.getParameter("cclave");
        nomUsu = request.getParameter("cnombre");
        apeUsu = request.getParameter("capellido");
        email = request.getParameter("cemail");
        telefono = request.getParameter("ctelefono");
        direccion = request.getParameter("cdireccion");
        idTipoUsu = Integer.parseInt(request.getParameter("cperfil"));

        Usuario usuario = new Usuario(idUsu, usuarioLogin, clave, nomUsu, apeUsu, email, telefono, direccion, idTipoUsu);

        usuario.setIdUsu(idUsu);
        usuario.setUsuarioLogin(usuarioLogin);
        usuario.setClave(clave);
        usuario.setNomUsu(nomUsu);
        usuario.setApeUsu(apeUsu);
        usuario.setEmail(email);
        usuario.setTelefono(telefono);
        usuario.setDireccion(direccion);
        usuario.setIdTipoUsu(idTipoUsu);

        int status = UsuarioDAO.agregarUsuario(usuario);

        if (status > 0) {
            response.sendRedirect("mensaje.jsp");
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
