<jsp:useBean id="Usuario" class="Modelo.UsuarioBean" scope="session"/>
<%

    int Direccion = 0;
    Direccion = Integer.parseInt(request.getParameter("dir"));
    switch (Direccion) {
         case 0:
            request.getRequestDispatcher("Index.jsp").forward(request, response);
            break;
        case 1:
            Usuario.DesactivarError();
            Usuario.setNuevo_Usuario(false);
            request.getRequestDispatcher("Login_Registrar.jsp").forward(request, response);
            break;
             case 2:
                 if (Usuario.getEstado()) {
                          request.getRequestDispatcher("Registrar_Empleado.jsp").forward(request, response);
                     }else{
                 request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
            break;
              case 3:
                    if (Usuario.getEstado()) {
                          request.getRequestDispatcher("Lista_Empleados.jsp").forward(request, response);
                     }else{
                 request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
            break;
             case 4:
                    if (Usuario.getEstado()) {
                          request.getRequestDispatcher("Asignar_Prestacion.jsp").forward(request, response);
                     }else{
                 request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
            break;
            case 5:
                    if (Usuario.getEstado()) {
                          request.getRequestDispatcher("Lista_Prestaciones.jsp").forward(request, response);
                     }else{
                 request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
            break;
        default:
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            break;

    }


%>