
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.PrestacionesBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Web</title>
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width = device-width, initial-scale=1">
        <link rel="stylesheet" href="Styles/Estilo1.css" type="text/css">
         <link rel="stylesheet" href="http://www.menucool.com/vertical/vm/menu-vertical.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="http://www.menucool.com/vertical/vm/menu-vertical.js"></script>
        <jsp:useBean id="ConexionDB" class="Modelo.Conexion_DB" scope="page"/>
    </head>
     <body style="margin-left: 15%;">
        <div id="BoxLogo">
            <img class="Img" src="Inmagenes/Principal.jpg" alt="Imposible cargar inmagen"/>
        </div>
        <div id="contenido">
            <jsp:include page="Menu.html"/>
            <jsp:include page="Estadistica.jsp"/>  
            <div id="BoxContenido" >
                  <table class="table-hover" id="tableR">
                      <caption><center><h1>Listado Prestaciones</h1></center></caption>
                    <thead>
                        <th>Id</th>
                        <th>Horas Trabajadas</th>
                        <th>Tarifa Horaria</th>
                        <th>AFP</th>
                        <th>Mes</th>
                        <th>Año</th>
                        <th>Total</th>
                        <th>Estado</th>
                  </thead>
                    <%
                        int pos = 0;
                        ArrayList<PrestacionesBean> lista = ConexionDB.getListaPrestaciones();
                        for (PrestacionesBean emple : lista) {
                            out.println("<tr>");
                            out.println("<td>" + emple.getId() + "</td>");
                            out.println("<td>" + emple.getHoras_trabajadas() + "</td>");
                            out.println("<td>" + emple.getTarifa() + "</td>");
                            out.println("<td>" + emple.getAFP() + "</td>");
                            out.println("<td>" + emple.getMes() + "</td>");
                            out.println("<td>" + emple.getYear() + "</td>");
                            out.println("<td>" + emple.getTotal() + "</td>");
                            out.println("<td>" + emple.getEstado() + "</td>");
                            if (emple.getEstado().equals("PAGADO")) {
                                     out.println("<td> <p class=\"bg-info\">Exito</p></td>");
                                }else{
                             out.println("<td><a href=\"doPagar.jsp?pos="+emple.getId()+"\" class=\"btn btn-success\">Pagar</a></td>");
                            }
                           
                            %>
                            
                    <%
                            out.println("</tr>");
                            pos++;
                       }
                    %>
                  </table>
            </div>

        </div>
      
    </body>
</html>
