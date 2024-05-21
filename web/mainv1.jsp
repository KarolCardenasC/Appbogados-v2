<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*, modelo.Usuario" errorPage="" %>
<%@ page import="modelo.Conexion" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
// Obtener el nombre de usuario de la sesión
//HttpSession session = request.getSession();
String nombreUsuario = (String) session.getAttribute("nombreUsuario");

// Declaración de variables para almacenar los datos del usuario
String idUsu = "";
String usuarioLogin = "";
String nomUsu = "";
String apeUsu = "";
int idTipoUsu = 0;
List<String> actividades = new ArrayList<>();

// Declaración de objetos de conexión a la base de datos
Connection con = null;
Statement sentencia = null;
ResultSet resultado = null;

try {
    // Se crea la conexión a la base de datos
    Conexion cn = new Conexion();
    con = cn.crearConexion();
    
    // Se crea la sentencia SQL para obtener los datos del usuario
    sentencia = con.createStatement();
    resultado = sentencia.executeQuery("SELECT * from usuarios WHERE usuarioLogin = '" + nombreUsuario + "' ");
    
    // Se recorre el resultado y se asignan los valores a las variables correspondientes
    while (resultado.next()) {
        idUsu = resultado.getString("idUsu");
        usuarioLogin = resultado.getString("usuarioLogin");
        nomUsu = resultado.getString("nomUsu");
        apeUsu = resultado.getString("apeUsu");
        idTipoUsu = resultado.getInt("idTipoUsu");
    }

    
// Se crea una nueva consulta SQL para obtener las actividades habilitadas para el usuario
    resultado = sentencia.executeQuery("SELECT actividades.nom_actividad AS actividad, actividades.enlace AS enlace " +
                                       "FROM gestActividad " +
                                       "JOIN perfiles ON gestActividad.id_perfil = perfiles.id_perfil " +
                                       "JOIN actividades ON gestActividad.id_actividad = actividades.id_actividad " +
                                       "WHERE perfiles.id_perfil = " + idTipoUsu);
    
    // Se recorre el resultado y se agregan las actividades a la lista
        while (resultado.next()) {
            String nombreActividad = resultado.getString("actividad");
            String enlaceActividad = resultado.getString("enlace");
            actividades.add(nombreActividad + "_" + enlaceActividad); // Agregar actividad con el formato "nombre_enlace"
        }
    
    
    
    } catch(Exception e) {
    // Manejo de la excepción
    e.printStackTrace();
} finally {
    // Se cierran los recursos de la base de datos
    try {
        if (resultado != null) resultado.close();
        if (sentencia != null) sentencia.close();
        if (con != null) con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
%>




<html>
    <head>
        <title>Home Appbogados</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            html,body,h1,h2,h3,h4,h5 {
                font-family: "Raleway", sans-serif
            }
            #apDiv1 {
                position: absolute;
                left: 324px;
                top: 58px;
                width: 1292px;
                height: 647px;
                z-index: 1;
            }
        </style>
    </head>
    <body class="w3-light-">

        <!-- Top container -->
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onClick="w3_open();"><i class="fa fa-bars"></i>  Menu </button>
            <span class="w3-bar-item w3-right">
                <a href="index.jsp" class="w3-bar-item w3-right">Logout</a>
            </span>

            <script>
                function logout() {
                    // Enviar una solicitud al servidor para cerrar la sesión
                    fetch('logout', {method: 'POST'})
                            .then(response => {
                                // Redirigir al usuario a la página de inicio después de cerrar sesión
                                window.location.href = 'index.jsp';
                            })
                            .catch(error => {
                                console.error('Error al cerrar sesión:', error);
                            });
                }
            </script>

        </div>


        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s8 w3-bar">
                    <span> Bienvenido, <strong><%= nomUsu %> <%= apeUsu %></strong></span><br>
                </div>
            </div>
            <hr>
            <div class="w3-container">
                <!--<h5>Home</a></h5>-->
            </div>
            <div class="w3-bar-block">
                <a href="#" class="w3-bar-item w3-button w3-padding w3-Orange"><i class="fa fa-users fa-fw"></i>HOME</a>

                <!-- Iterar sobre las actividades y mostrarlas como enlaces -->
                <% for (String actividad : actividades) {
                    String[] partes = actividad.split("_");
                    String nombre = partes[0];
                    String enlace = partes[1];
                %>
                <a href="<%= enlace %>" class="w3-bar-item w3-button" target="marco"><%= nombre %></a>
                <% } %>

                <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onClick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
                <br><br>
            </div>
        </nav>


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onClick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">
            <div id="apDiv1"><iframe width="1292" height="1200" name="marco" frameborder="0"></iframe></div>
            <!-- Header 
            </header>-->
            <!-- Footer 
            <footer class="w3-container w3-padding-16 w3-light-grey">
            </footer> -->
            <!-- End page content -->
        </div>

        <script>
            // Get the Sidebar
            var mySidebar = document.getElementById("mySidebar");

            // Get the DIV with overlay effect
            var overlayBg = document.getElementById("myOverlay");

            // Toggle between showing and hiding the sidebar, and add overlay effect
            function w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

            // Close the sidebar with the close button
            function w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }
        </script>

    </body>
</html>
