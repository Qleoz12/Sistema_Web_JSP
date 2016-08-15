<%-- 
    Document   : Lista_Empleados
    Created on : Jul 20, 2016, 8:42:03 PM
    Author     : JoseEduardo
--%>

<%@page import="Modelo.EmpleadoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <jsp:useBean id="ConexionDB" class="Modelo.Conexion_DB" scope="page"/>
        <title>Sistema web</title>
    </head>
     <body style="margin-left: 15%;">
        <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
            <jsp:include page="Estadistica.jsp"/>  
            <div id="BoxContenido" style="width: auto;" >
                <table class="table-hover" id="tableR">
                    <caption><center><h1>Listado Empleados</h1></center></caption>
                    <thead>
                        <th>Id</th>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Fecha Nacimiento</th>
                        <th>Sexo</th>
                        <th>Direccion</th>
                        <th>Telefono</th>
                        <th>Email</th>
                </thead>
                    <%
                        ArrayList<EmpleadoBean> lista = ConexionDB.getLista_Empleados();
                        for (EmpleadoBean emple : lista) {
                            out.println("<tr>");
                            out.println("<td>" + emple.getId() + "</td>");
                            out.println("<td>" + emple.getCedula() + "</td>");
                            out.println("<td>" + emple.getNombre() + "</td>");
                            out.println("<td>" + emple.getApellido() + "</td>");
                            out.println("<td>" + emple.getFecha_Nacimineto() + "</td>");
                            out.println("<td>" + emple.getSexo() + "</td>");
                            out.println("<td>" + emple.getDireccion() + "</td>");
                            out.println("<td>" + emple.getTelefono() + "</td>");
                            out.println("<td>" + emple.getEmail() + "</td>");
                            out.println("</tr>");
                        }
                    %>

                </table>

            </div>

        </div>
       

    </body>
</html>
