
package Controlador;

import Modelo.Conexion_DB;
import Modelo.EmpleadoBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class doRegistrarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //de registracion empleado del empleado
        String Id = request.getParameter("txtId");
        String Cedula = request.getParameter("txtCedula");
        String Nombre = request.getParameter("txtNombre");;
        String Apellido = request.getParameter("txtApellido");;
        String Sexo = request.getParameter("Sexo");
        String Fecha_Nacimineto = request.getParameter("txtDate");
        String Direccion = request.getParameter("txtDireccion");
        String Telefono = request.getParameter("txtTelefono"); 
        String Email = request.getParameter("txtEmail");;
        EmpleadoBean emple = new EmpleadoBean();
        emple.setId(Id);
        emple.setCedula(Cedula);
        emple.setNombre(Nombre);
        emple.setApellido(Apellido);
        emple.setFecha_Nacimineto(Fecha_Nacimineto);
        emple.setSexo(Sexo);
        emple.setDireccion(Direccion);
        emple.setTelefono(Telefono);
        emple.setEmail(Email);
        if (emple.ValidarEmpleado()) {
            Conexion_DB Mi_conexion = new Conexion_DB();
            Boolean Exito = Mi_conexion.AgregarEmpleado(emple);
            if (Exito) {
                emple.LimpiarErrores();
                 request.getRequestDispatcher("Exito.jsp").forward(request, response);
            }
             request.getRequestDispatcher("Error.jsp").forward(request, response);
        }else{
         request.setAttribute("Empleado", emple);
         request.getRequestDispatcher("Registrar_Empleado.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
