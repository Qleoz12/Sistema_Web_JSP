<%-- 
    Document   : Asignar_Prestacion
    Created on : Jul 22, 2016, 12:22:20 AM
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
        <title>Sistema Web</title>
        <jsp:useBean id="EmpleadoB" class="Modelo.EmpleadoBean" scope="request"/>
        <jsp:useBean id="Prestaciones" class="Modelo.PrestacionesBean" scope="request"/>
    </head>
    <body style="margin-left: 15%;">
        <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
            <jsp:include page="Estadistica.jsp"/>  
            <div id="BoxContenido" style=" height: auto " >
                <center><h1>Formulario prestaciones</h1></center>
                    <%
                        if (!Prestaciones.getErrores().isEmpty()) {
                            out.println("<center><h2 id=\"Advertencia\">----Atención---</h2></center>");
                            out.println("<ul>");
                            for (String str : Prestaciones.getErrores()) {
                                out.println("<li>" + str + "</li>");
                            }
                        }
                    %>
                    <form action="doBuscar" class="pure-form pure-form-aligned">
                        <div class="pure-control-group">
                            <label>Buscar ID empleado </label> <input type="text" name="TxtBuscar" size="12" value="${EmpleadoB.id}">
                            <input type="submit" value="Buscar" class="btn btn-info"/>
                        </div>

                    </form>  
               
                <table class="table-hover" id="tableR">
                    <tr>
                        <th>ID</th>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                    </tr>
                    <tr>
                        <%
                            if (EmpleadoB.getBuscar() == true) {
                        %>
                        <td>${EmpleadoB.id}</td>
                        <td>${EmpleadoB.cedula}</td>
                        <td>${EmpleadoB.nombre}</td>
                        <td>${EmpleadoB.apellido}</td>
                        <%
                            }
                        %>

                    </tr>
                </table>   

                <form class="pure-form pure-form-aligned" action="doPrestaciones">
                    <fieldset>
                        <div class="pure-control-group"> 
                            <label>ID</label>
                            <input type="text" size="10" name="TxtID" value="${EmpleadoB.id}">
                        </div>
                        <div class="pure-control-group">
                            <label>Horas Trabajadas</label> 
                            <input type="text" size="10" name="TxtHoras_Trabajadas" value="${Prestaciones.horas_trabajadas}">
                        </div>
                        <div class="pure-control-group">
                            <label>Tarifa Horaria</label>
                            <input type="text" size="10" name="TxtTarifa" value="${Prestaciones.tarifa}">
                        </div>
                        <div class="pure-control-group">
                            <label>Afp: 2.72%</label>
                        </div>
                        <div class="pure-control-group">
                            <label>Mes</label> <select name="TxtMes">
                                <option value="Enero">Enero</option>
                                <option value="Febrero">Febrero</option>
                                <option value="Marzo">Marzo</option>
                                <option value="Abril">Abril</option>
                                <option value="Mayo">Mayo</option>
                                <option value="Junio">Junio</option>
                                <option value="Julio">Julio</option>
                                <option value="Agosto">Agosto</option>
                                <option value="Septiembre">Septiembre</option>
                                <option value="Octubre">Octubre</option>
                                <option value="Nomviembre">Nomviembre</option>
                                <option value="Diciembre">Diciembre</option>
                            </select>
                        </div>
                        <div class="pure-control-group">
                            <label>Año</label> 
                            <input type="text" size="10" name="Txtyear" value="${Prestaciones.year}">
                        </div>
                        <div class="pure-control-group">
                            <label></label><input type="submit"  class="pure-button pure-button-primary" value="Enviar"/>
                        </div>
                    </fieldset>
                </form>
               
            </div>
        </div>
    </body>
</html>
