<%-- 
    Document   : Registrar_Empleado
    Created on : Jul 19, 2016, 6:27:46 PM
    Author     : JoseEduardo
--%>

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
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <script type="text/javascript" src="http://www.menucool.com/vertical/vm/menu-vertical.js"></script>
        <jsp:useBean id="Empleado" class="Modelo.EmpleadoBean" scope="request"/>
        <title>Sistema Web </title>
    </head>
    <body style="margin-left: 15%;">
        <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
            <jsp:include page="Estadistica.jsp"/>  
            <div id="BoxContenido" style=" height: auto " >
                <center><h1>Registración nuevo empleado</h1></center>
                <%
                    if (!Empleado.getErrores().isEmpty()) {
                        out.println("<center><h2 id=\"Advertencia\">----Atención---</h2></center>");
                        out.println("<ul>");
                        for (String str : Empleado.getErrores()) {
                %>
                <li> <%= str%> </li>
                    <%
                            }
                            out.println("</ul>");
                        }
                    %>
                <form class="pure-form pure-form-aligned" action="doRegistrarEmpleado" method="post" >
                    <fieldset>
                        <div class="pure-control-group">
                            <label>Id</label>
                            <input type="text" name="txtId" value="${Empleado.id}" placeholder="ID" />
                        </div>
                        <div class="pure-control-group">
                            <label>Cedula</label>
                            <input type="text" name="txtCedula" value="${Empleado.cedula}" placeholder="Cedula" />
                        </div>
                        <div class="pure-control-group">
                           <label>Nombre</label>
                           <input type="text" name="txtNombre" value="${Empleado.nombre}" placeholder="Nombre"/>
                        </div>
                        <div class="pure-control-group">
                            <label>Apellido </label>
                             <input type="text" name="txtApellido" value="${Empleado.apellido}" placeholder="Apellido"/>
                        </div>
                        
                         <div class="pure-control-group">
                          <label>Fecha Nacimiento</label>
                              <input type="text" name="txtDate" value="${Empleado.fecha_Nacimineto}" placeholder="Fecha"/>
                        </div>
                         <div class="pure-control-group">
                             <label>Sexo:</label>
                             <input type="radio" name="Sexo" value="M" checked="checked"/>M <input type="radio" name="Sexo" value="F"/> F
                        </div>
                         <div class="pure-control-group">
                           <label>Dirección</label>
                           <input type="text" name="txtDireccion" value="${Empleado.direccion}" placeholder="Dirección" />
                        </div>
                        <div class="pure-control-group">
                            <label>Telefono</label>
                            <input type="text" name="txtTelefono" value="${Empleado.telefono}" placeholder="Telefono"/>
                        </div> <div class="pure-control-group">
                           <label>Email</label>
                               <input type="text" name="txtEmail" value="${Empleado.email}" placeholder="Email"/>
                        </div>
                        <div class="pure-controls">

                            <button type="submit" class="pure-button pure-button-primary">Enviar</button>
                        </div>
                    </fieldset>
                </form>
            </div>

        </div>

    </body>
</html>
