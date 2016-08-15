/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion_DB;
import Modelo.EmpleadoBean;
import Modelo.PrestacionesBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JoseEduardo
 */
public class doPrestaciones extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Id = request.getParameter("TxtID");
        String Horas_Trabajadas = request.getParameter("TxtHoras_Trabajadas");
        String Tarifa = request.getParameter("TxtTarifa");
        String Mes = request.getParameter("TxtMes");
        String year = request.getParameter("Txtyear");
        PrestacionesBean presta = new PrestacionesBean();
        presta.setId(Id);
        presta.setHoras_trabajadas(Horas_Trabajadas);
        presta.setTarifa(Tarifa);
        presta.setMes(Mes);
        presta.setYear(year);
        if (presta.ValidarPrestacion()) {
            presta.LimpiarErrores();
            Conexion_DB ConexionDB = new Conexion_DB();
            boolean Exito = ConexionDB.AgregarPrestacion(presta);
            if (Exito) {
                request.getRequestDispatcher("Exito.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        }else{
           request.setAttribute("Prestaciones", presta);
           request.getRequestDispatcher("Asignar_Prestacion.jsp").forward(request, response);       
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
