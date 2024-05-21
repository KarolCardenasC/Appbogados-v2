<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Usuario" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Buscar Usuario</title>
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

        <h2>Formulario de Búsqueda de Usuario</h2>
        <form action="ContBuscarU" method="POST">
            <div>
                <label for="idUsu">ID Usuario:</label>
                <input type="text" id="idUsu" name="idUsu" required>
            </div>
            <div>
                <input type="submit" name="buscar" value="Buscar"/>
            </div>
        </form>

        <%
        Usuario usuario = (Usuario) request.getAttribute("usuario");
        String tipoUsuario = "Desconocido";

        if (usuario != null) { // Verificar si se encontró el usuario
            switch (usuario.getIdTipoUsu()) {
                case 1:
                    tipoUsuario = "Administrador";
                    break;
                case 2:
                    tipoUsuario = "Abogado";
                    break;
                case 3:
                    tipoUsuario = "Funcionario";
                    break;
                case 4:
                    tipoUsuario = "Cliente";
                    break;
                default:
                    tipoUsuario = "Desconocido";
                    break;
            }
        %>

        <h2>Resultado de la búsqueda de usuario</h2>
        <p>ID: <%= usuario.getIdUsu() %></p>
        <p>Nombre: <%= usuario.getNomUsu() %></p>
        <p>Apellido: <%= usuario.getApeUsu() %></p>
        <p>Email: <%= usuario.getEmail() %></p>
        <p>Teléfono: <%= usuario.getTelefono() %></p>
        <p>Dirección: <%= usuario.getDireccion() %></p>
        <p>Tipo de usuario: <%= tipoUsuario %></p>
        <!-- Agregar más detalles del usuario según sea necesario -->

        <% } %>

    </body>
</html>

