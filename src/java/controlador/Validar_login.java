/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import modelo.LoginDAO;
import modelo.Usuario;

/**
 *
 * @author JC17
 */
public class Validar_login extends HttpServlet {

    LoginDAO logindao = new LoginDAO();
    Usuario usuarioEncontrado = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Se obtiene la sesión actual o se crea una nueva si no existe
    HttpSession session = request.getSession(true);
    
    // Se obtiene el parámetro "accion" del formulario enviado desde el cliente
    String accion = request.getParameter("accion");

    // Se verifica si la acción es "Ingresar"
    if (accion.equalsIgnoreCase("Ingresar")) {
        
        // Se obtienen el nombre de usuario y la clave enviados desde el formulario
        String nombreUsuario = request.getParameter("usrname");
        String clave = request.getParameter("psw");
        
        // Se llama al método de LoginDAO para buscar el usuario en la base de datos
        // utilizando el nombre de usuario y la clave proporcionados
        Usuario usuEnc = logindao.Login_Usuario(nombreUsuario, clave);
        
        // Se verifica si se encontró un usuario con las credenciales proporcionadas
        if (usuEnc != null) {
            // Si se encontró un usuario, se guarda en el request como atributo
            // con el nombre "usuEnc"
            request.setAttribute("usuEnc", usuEnc);
            
            // Se crea o se obtiene la sesión del usuario y se guarda el nombre de usuario
            HttpSession sesionUsuario = request.getSession(true);
            sesionUsuario.setAttribute("nombreUsuario", nombreUsuario);
            
            // Se redirige al usuario a la página principal del sistema
            request.getRequestDispatcher("mainv1.jsp").forward(request, response);
        } else {
            // Si no se encontró un usuario, se redirige al usuario de vuelta al formulario de inicio de sesión
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } else {
        // Si la acción no es "Ingresar", se redirige al usuario de vuelta al formulario de inicio de sesión
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
