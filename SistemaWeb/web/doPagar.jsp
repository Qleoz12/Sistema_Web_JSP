

<%@page import="Modelo.Conexion_DB"%>
<%

    String Id = request.getParameter("pos");
    Conexion_DB Mi_Conexion = new Conexion_DB();
    boolean Exito = Mi_Conexion.PagarPrestacion(Id);
    if (Exito) {
        request.getRequestDispatcher("Lista_Prestaciones.jsp").forward(request, response);
    } else {
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }

%>