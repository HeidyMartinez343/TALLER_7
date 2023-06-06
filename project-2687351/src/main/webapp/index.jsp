<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %><%--suppress SpellCheckingInspection --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <!--METADATA-->
  <!--charset para caracteres especiales -->
  <meta charset="UTF-8">
  <!--author-->
  <meta name="author" content="Heidy Martinez">
  <!--description-->
  <meta name="description" content="Formulario de inicio de seccion">
  <!--keywords-->
  <meta name="keywords" content="registro de ususario, formulario de registro,  crear cuenta, registro en linea">
  <!--minimum responsive viewport-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--Title-->
  <title>Formulario de Registro</title>
  <!--Favicon-->
  <link rel="icon" type="image/x-icon" href="./img/anadir.png">
  <!--CSS-->
  <!--bootstrap css / icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
        crossorigin="anonymous">
  <link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <!--custom css-->
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<!--login form--->
<div class="container">
  <h2>Formulario de Registro</h2>
  <form>
    <img class="mb-4" src="img/r.png" alt="index" width="95">
    <label for="firstname">NOMBRE</label>
    <input type="text" id="firstname" name="firstname" placeholder="ingrese su nombre" required autofocus pattern="[A-Za-z]{2,40}">
    <label for="lastname">APELLIDO</label>
    <input type="text" id="lastname" name="lastname" placeholder="ingrese su apellido" required pattern="[A-Za-z]{2,40}">
    <label for="email">CORREO</label>
    <input type="email" id="email" name="email" placeholder="ingrese su correo" required pattern="{40}">
    <label for="password">CONTRASEÑA</label>
    <input type="password" id="password" name="password" placeholder="igrese una contraseña" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,256}$">
    <button type="submit">ENVIAR</button>
    <p class="mt-3 mb-3 text-muted"> Todos los Derechos Reservados Index
      © <%=displayDate()%>
    </p>

  </form>
</div>

<!-- Bootstrap script-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
<%!
  public String displayDate () {
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
    Date date = Calendar.getInstance().getTime();
    return dateFormat.format(date);
  }
%>
</body>
</html>

