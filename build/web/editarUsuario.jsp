<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Usuario" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Usuario</title>
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
            input[readonly] {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>

        <%-- Formulario de Búsqueda de Usuario --%>
        <h2>Formulario de Actualizacion de Usuario</h2>
        <form action="ContEditU?action=buscar" method="POST">
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

        if (usuario != null) { // Verificar si se encontró el usuario
        %>

        <%-- Formulario de Edición de Usuario --%>
        <h2>Editar Usuario</h2>
        <form action="ContEditU?action=actualizar" method="POST">
            <div>
                <label for="idUsuario">ID Usuario:</label>
                <input type="text" id="idUsuario" name="idUsuario" value="<%= usuario.getIdUsu() %>" readonly>
            </div>
            <div>
                <label for="nomUsu">Nombre:</label>
                <input type="text" id="nomUsu" name="nomUsu" value="<%= usuario.getNomUsu() %>" required>
            </div>
            <div>
                <label for="apeUsu">Apellido:</label>
                <input type="text" id="apeUsu" name="apeUsu" value="<%= usuario.getApeUsu() %>" required>
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= usuario.getEmail() %>" required>
            </div>
            <div>
                <label for="telefono">Teléfono:</label>
                <input type="tel" id="telefono" name="telefono" value="<%= usuario.getTelefono() %>" required>
            </div>
            <div>
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion" value="<%= usuario.getDireccion() %>" required>
            </div>
            <div>
                <label for="idTipoUsu">Tipo de Usuario:</label>
                <select id="idTipoUsu" name="idTipoUsu">
                    <option value="1" <%= (usuario.getIdTipoUsu() == 1) ? "selected" : "" %>>Administrador</option>
                    <option value="2" <%= (usuario.getIdTipoUsu() == 2) ? "selected" : "" %>>Abogado</option>
                    <option value="3" <%= (usuario.getIdTipoUsu() == 3) ? "selected" : "" %>>Funcionario</option>
                    <option value="4" <%= (usuario.getIdTipoUsu() == 4) ? "selected" : "" %>>Cliente</option>
                </select>
            </div>
            <div>
                <input type="submit" name="actualizar" value="Actualizar"/>
            </div>
        </form>

        <% } else { %>

        <%-- Mensaje si no se encontró ningún usuario --%>
        <h2>Usuario no encontrado</h2>

        <% } %>

    </body>
</html>
