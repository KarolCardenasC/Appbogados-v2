package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    /* Método para agregar un nuevo usuario */
    public static int agregarUsuario(Usuario usuario) {
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        int estatus = 0;

        try {
            con = cn.crearConexion();
            String query = "INSERT INTO usuarios (idUsu, usuarioLogin, clave, NomUsu, ApeUsu, Email, Telefono, Direccion, idTipoUsu)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);
            ps.setString(1, usuario.getIdUsu());
            ps.setString(2, usuario.getUsuarioLogin());
            ps.setString(3, usuario.getClave());
            ps.setString(4, usuario.getNomUsu());
            ps.setString(5, usuario.getApeUsu());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getDireccion());
            ps.setInt(9, usuario.getIdTipoUsu());

            estatus = ps.executeUpdate();
            con.close();

            System.out.print("REGISTRO GUARDADO DE FORMA EXITOSA...");
        } catch (SQLException ex) {
            System.out.print("ERROR AL REGISTRAR EL USUARIO...");
            System.out.print(ex.getMessage());
        }

        return estatus;
    }

    /* Método para actualizar un usuario */
    public static int actualizarUsuario(Usuario usuario) {
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        int estatus = 0;

        try {
            con = cn.crearConexion();
            String query = "UPDATE usuarios SET NomUsu=?, ApeUsu=?, Email=?, Telefono=?, Direccion=?, idTipoUsu=? WHERE idUsu=?";

            ps = con.prepareStatement(query);
            ps.setString(1, usuario.getNomUsu());
            ps.setString(2, usuario.getApeUsu());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getDireccion());
            ps.setInt(6, usuario.getIdTipoUsu());
            ps.setString(7, usuario.getIdUsu()); // Aquí mantenemos solo la línea para el idUsu

            estatus = ps.executeUpdate();
            con.close();

            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el usuario: " + ex.getMessage());
        }

        return estatus;
    }


    /* Método para eliminar un usuario */
    public static int eliminarUsuario(String idUsu) {
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        int estatus = 0;

        try {
            con = cn.crearConexion();
            String query = "DELETE FROM usuarios WHERE idUsu=?";

            ps = con.prepareStatement(query);
            ps.setString(1, idUsu);

            estatus = ps.executeUpdate();
            con.close();

            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el usuario: " + ex.getMessage());
        }

        return estatus;
    }

    /* Método para obtener un usuario por su ID */
    public static Usuario obtenerUsuarioPorId(String idUsu) {
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Usuario usuario = null;

        try {
            con = cn.crearConexion();
            String query = "SELECT * FROM usuarios WHERE idUsu=?";

            ps = con.prepareStatement(query);
            ps.setString(1, idUsu);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsu(rs.getString("idUsu"));
                usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
                usuario.setClave(rs.getString("clave"));
                usuario.setNomUsu(rs.getString("NomUsu"));
                usuario.setApeUsu(rs.getString("ApeUsu"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setIdTipoUsu(rs.getInt("idTipoUsu"));

                // Imprimir el usuario recuperado
                System.out.println("Usuario encontrado:");
                System.out.println(usuario);
            } else {
                // Imprimir un mensaje si no se encuentra ningún usuario
                System.out.println("No se encontró ningún usuario con el ID especificado: " + idUsu);
            }

            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener el usuario: " + ex.getMessage());
        }

        return usuario;
    }

    /* Método para obtener todos los usuarios */
    public static List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Conexion cn = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = cn.crearConexion();
            String query = "SELECT * FROM usuarios";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsu(rs.getString("idUsu"));
                usuario.setUsuarioLogin(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setNomUsu(rs.getString("NomUsu"));
                usuario.setApeUsu(rs.getString("ApeUsu"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setIdTipoUsu(rs.getInt("idTipoUsu"));

                usuarios.add(usuario);
            }

            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los usuarios: " + ex.getMessage());
        }

        return usuarios;
    }
}
