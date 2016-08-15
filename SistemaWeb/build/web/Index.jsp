<!DOCTYPE html>

<html>
    <head>
        <title>Pagina Sistema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width = device-width, initial-scale=1">
        <link rel="stylesheet" href="Styles/Estilo1.css" type="text/css">
         <link rel="stylesheet" href="http://www.menucool.com/vertical/vm/menu-vertical.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="http://www.menucool.com/vertical/vm/menu-vertical.js"></script>
        <jsp:useBean id="Usuario" class="Modelo.UsuarioBean" scope="session"/>
    </head>
    <body style="margin-left: 15%;">
        <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
          <jsp:include page="Estadistica.jsp"/> 
            <div id="BoxContenido" >
             <img class="Img" src="Inmagenes/welcome.jpg"  alt="Imposible cargar inmagen"/> 
            </div>
        </div>

    </body>
</html>
