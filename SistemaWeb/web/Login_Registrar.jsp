<%-- 
    Document   : Login_Regsitrar
    Created on : Jul 18, 2016, 9:29:07 PM
    Author     : JoseEduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="Usuario" class="Modelo.UsuarioBean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width = device-width, initial-scale=1">
        <link rel="stylesheet" href="Styles/Estilo1.css" type="text/css">
        <link rel="stylesheet" href="http://www.menucool.com/vertical/vm/menu-vertical.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="http://www.menucool.com/vertical/vm/menu-vertical.js"></script>
        <title>login</title>
    </head>
    <body style="margin-left: 15%;">  
        <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
            <jsp:include page="Estadistica.jsp"/>  
            <div id="BoxContenido" style=" width: auto; height: auto;">
                <%
                    if (Usuario.isNuevo_Usuario()) {
                        if (Usuario.getError().equals("regtrue")) {
                            out.println("<h2>Error Las 2 passwolrd no coinciden</h2>");
                        }
                %>
               
                    <div class="login-page" style="width: 825px; height: auto;">
                    <div class="form">
                        <form class="login-form" action="doLogin?Registrar=nuevo" method="post">
                            <input type="text" placeholder="username" name="txtNombre1"/>
                            <input type="password" placeholder="password" name="txt1"/>
                            <input type="password" placeholder="password" name="txt2"/>
                             <button type="submit" class="btn btn-default">Registrar</button>
                        </form>
                    </div>
                </div>
                <%
                } else {
                         String Error = Usuario.getError();
                    if (Error.equals("true")) {
                        out.println("<h2>El nombre o la contraseña son incorectos</h2>");
                    }
                %>
                  
                    <div class="login-page" style="width: 825px; height: auto;">
                    <div class="form">
                        <form class="login-form" action="doLogin?Registrar=false" method="post">
                            <input type="text" placeholder="username" name="txtNombre"/>
                            <input type="password" placeholder="password" name="txtPassworld"/>
                             <button type="submit" class="btn btn-default">Login</button>
                        </form>
                        <p></p>
                        <form action="doLogin?Registrar=true" method="post"><input type="submit" class="Style2" value="Registrar ahora"/></form> 
                    </div>
                </div> 
                    <%  }%>
            </div>
        </div>
    </body>
</html>
