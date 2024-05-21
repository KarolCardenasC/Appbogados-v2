/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JC17
 */
//Modelo - Objeto de Acceso a datos (DAO) - LoginDAO
public class LoginDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs;
    int estado = 1;

    public LoginDAO() {
    }

    public Usuario Login_Usuario(String usuarioLogin, String clave) {
        Usuario usuLog = null;
        try {
            Conexion cn = new Conexion();
            conn = cn.crearConexion();
            stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM usuarios WHERE usuarioLogin=? AND clave = ?");
            stmt.setString(1, usuarioLogin);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();
            if (rs.next()) {
                usuLog = new Usuario();
                usuLog.setIdUsu(rs.getString("idUsu"));
                usuLog.setUsuarioLogin(rs.getString("usuario"));
                usuLog.setClave(rs.getString("clave"));
                usuLog.setNomUsu(rs.getString("nomUsu"));
                usuLog.setApeUsu(rs.getString("apeUsu"));
                usuLog.setEmail(rs.getString("email"));
                usuLog.setTelefono(rs.getString("telefono"));
                usuLog.setDireccion(rs.getString("direccion"));
                usuLog.setIdTipoUsu(rs.getInt("idTipoUsu"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
        return usuLog;
    }

}
