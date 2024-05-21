<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*, modelo.Usuario, modelo.UsuarioDAO" errorPage="" %>
<%@ page import="modelo.Conexion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Crear Usuario</title>
        <style>
            body {
                background-color: beige;
            }
            form {
                margin: 20px;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #fff;
            }
            label {
                display: block;
                margin-bottom: 10px;
            }
            input, select {
                width: 100%;
                padding: 8px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
            }
        </style>
    </head>
    <body>

        <h2>Formulario de Registro de Usuario</h2>
        <form action="ControladorUsuario" method="POST">
            <div>
                <label for="idUsu">ID Usuario:</label>
                <input type="text" id="idUsu" name="cid" required>
            </div>
            <div>
                <label for="clave">Clave:</label>
                <input type="password" id="clave" name="cclave" required>
            </div>
            <div>
                <label for="nomUsu">Nombre:</label>
                <input type="text" id="nomUsu" name="cnombre" required>
            </div>
            <div>
                <label for="apeUsu">Apellido:</label>
                <input type="text" id="apeUsu" name="capellido" required>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="cemail">
            </div>
            <div>
                <label for="telefono">Teléfono:</label>
                <input type="tel" id="telefono" name="ctelefono">
            </div>
            <div>
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="cdireccion">
            </div>
            <div>
                <label for="idTipoUsu">Tipo de Usuario:</label>
                <select id="idTipoUsu" name="cperfil" required>
                    <option value="1">Administrador</option>
                    <option value="2">Abogado</option>
                    <option value="3">Funcionario</option>
                    <option value="4">Cliente</option>
                </select>
            </div>
            <div>
                <input type="submit" name="enviar" value="Enviar"/>
            </div>
        </form>

    </body>
</html>
