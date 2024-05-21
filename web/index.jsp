<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<title>Login Pool Abogados</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
  body {
    background-color: beige; /* Establece el color de fondo del cuerpo a beige */
  }
</style>
<body>
    <h2> <center> Login </center></h2>
    <div class="w3-center"><br>
    </div>
      <form class="w3-container" action="Validar_login" method="post">
        <div class="w3-section">
          <label><b>ID Usuario</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter ID" name="usrname" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="psw" required> <!-- Cambiado a type="password" -->
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
          <input type="hidden" name="accion" value="Ingresar">

        </div>
      </form>

	<span class="w3-right w3-padding w3-hide-small">Olvidó su <a href="#">password?</a></span>
    </div>
  </div>
</body>
</html>

