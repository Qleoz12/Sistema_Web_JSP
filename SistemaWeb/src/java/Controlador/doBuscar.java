/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion_DB;
import Modelo.EmpleadoBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JoseEduardo
 */
public class doBuscar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Id = request.getParameter("TxtBuscar");
        Conexion_DB Conexion = new Conexion_DB();
        EmpleadoBean Empleado = Conexion.BuscarEmpleado(Id);
        Empleado.setBuscar(true);
        if (true) {
            request.setAttribute("EmpleadoB", Empleado);
            request.getRequestDispatcher("Asignar_Prestacion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
