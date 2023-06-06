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
    <meta name="author" content="Sebastian Morales">
    <!--description-->
    <meta name="description" content="Formulario de Registro de Productos">
    <!--keywords-->
    <meta name="keywords" content="Código de producto, Nombre del producto, Precio, Categoría del producto">
    <!--minimum responsive viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--Title-->
    <title>Formulario de Registro de Productos</title>
    <!--Favicon-->
    <link rel="icon" type="image/x-icon" href="./img/caja.png">
    <!--CSS-->
    <!--bootstrap css / icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <!--custom css-->
    <link rel="stylesheet" href="css/style_p.css">
</head>
<body>
<!--login form--->
<div class="container">

    <form action="#" method="post">
        <h2>Formulario de Registro de Productos</h2>
        <img class="mb-4" src="img/caja.png" alt="index" width="125">
        <label for="product_name">NOMBRE</label>
        <input type="text" id="product_name" name="product_name" placeholder="ingrese el nombre del producto nuevo" required autofocus pattern="[A-Za-z]{2,40}">
        <label for="product_value">VALOR</label>
        <input type="text" id="product_value" name="product_value" placeholder="ingrese el valor del producto nuevo" required pattern="[A-Za-z]{2,40}">
        <label for="category_id">CATEGORIA</label>
        <input type="text" id="category_id" name="category_id" placeholder="ingrese la id de la categoria del producto" required pattern="[A-Za-z]{2,40}">
        <button type="submit">ENVIAR</button>
        <p class="mt-3 mb-3 text-muted"> Todos los Derechos Reservados products
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