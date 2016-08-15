<%-- 
    Document   : Exito
    Created on : Jul 23, 2016, 2:04:11 AM
    Author     : JoseEduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Pagina Sistema</title>
        <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width = device-width, initial-scale=1">
        <link rel="stylesheet" href="Styles/Estilo1.css" type="text/css">
         <link rel="stylesheet" href="http://www.menucool.com/vertical/vm/menu-vertical.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="http://www.menucool.com/vertical/vm/menu-vertical.js"></script>
    </head>
    <body  style="margin-left: 15%;">
         <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
            <jsp:include page="Estadistica.jsp"/>  
            <div id="BoxContenido" >
                <img src="Inmagenes/Success.jpg"/>
            
            </div>

        </div>
            <div class="foot" style=" border: none">
                <center><h1><a href="Index.jsp" class="btn btn-success">Continua</a></h1></center> 
        </div>
    </body>
</html>
