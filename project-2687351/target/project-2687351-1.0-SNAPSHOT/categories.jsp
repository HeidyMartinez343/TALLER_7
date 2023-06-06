<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <!--METADATA-->
    <!--charset para caracteres especiales -->
    <meta charset="UTF-8">
    <!--author-->
    <meta name="author" content="Sebastian Morales">
    <!--description-->
    <meta name="description" content="Formulario de categorias de productp">
    <!--keywords-->
    <meta name="keywords" content="Nombre de la categoría, Código de categoría">
    <!--minimum responsive viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--Title-->
    <title>Categorias</title>
    <!--Favicon-->
    <link rel="icon" type="image/x-icon" href="./img/categorias.png">
    <!--CSS-->
    <!--bootstrap css / icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <!--custom css-->
    <link rel="stylesheet" href="css/style_c.css">
</head>
<body>
<!--login form--->
<div class="container">

    <form action="#" method="post">
        <h2>categorias</h2>
        <img class="mb-4" src="img/categorias.png" alt="index2" width="125">
        <label for="category_name">NOMBRE DE LA CATEGORIA</label>
        <input type="text" id="category_name" name="category_name" placeholder="ingrese el nombre de la nueva categoria" required autofocus pattern="[A-Za-z]{2,40}">
        <button type="submit">ENVIAR</button>
        <p class="mt-3 mb-3 text-muted"> Todos los Derechos Reservados categories
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