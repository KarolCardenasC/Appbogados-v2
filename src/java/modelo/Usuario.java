/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JC17
 */


public class Usuario {
String idUsu;
String usuarioLogin;
String clave;
String nomUsu;
String apeUsu;
String email;
String telefono;
String direccion;
int idTipoUsu;


public Usuario() {
}
public Usuario(String idUsu, String usuarioLogin, String clave, String nomUsu, String apeUsu, String email, String telefono, String direccion, int idTipoUsu) {
this.idUsu = idUsu;
this.usuarioLogin = usuarioLogin;
this.clave = clave;
this.nomUsu = nomUsu;
this.apeUsu = apeUsu;
this.email = email;
this.telefono = telefono;
this.direccion = direccion;
this.idTipoUsu = idTipoUsu;
}

public String getIdUsu() {
    return idUsu;
}

public String getUsuarioLogin() {
    return usuarioLogin;
}

public String getClave() {
    return clave;
}

public String getNomUsu() {
    return nomUsu;
}

public String getApeUsu() {
    return apeUsu;
}

public String getEmail() {
    return email;
}

public String getTelefono() {
    return telefono;
}

public String getDireccion() {
    return direccion;
}

public int getIdTipoUsu() {
    return idTipoUsu;
}

// Setters
public void setIdUsu(String idUsu) {
    this.idUsu = idUsu;
}

public void setUsuarioLogin(String usuarioLogin) {
    this.usuarioLogin = usuarioLogin;
}

public void setClave(String clave) {
    this.clave = clave;
}

public void setNomUsu(String nomUsu) {
    this.nomUsu = nomUsu;
}

public void setApeUsu(String apeUsu) {
    this.apeUsu = apeUsu;
}

public void setEmail(String email) {
    this.email = email;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public void setIdTipoUsu (int idTipoUsu) {
    this.idTipoUsu = idTipoUsu;
}

}