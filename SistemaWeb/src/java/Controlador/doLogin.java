/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion_DB;
import Modelo.UsuarioBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JoseEduardo
 */
@WebServlet(name = "doLogin", urlPatterns = {"/doLogin"})
public class doLogin extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String reg = request.getParameter("Registrar");
         UsuarioBean us = (UsuarioBean) request.getSession().getValue("Usuario");
          Conexion_DB Mi_ConexionDB = new Conexion_DB();
        switch (reg) {
            case "false":
                us.setNombre(request.getParameter("txtNombre"));
                us.setPassworld(request.getParameter("txtPassworld"));
                boolean Valido = Mi_ConexionDB.ValidarUsuario(us);
                if (Valido) {
                    us.ActivatUsuario();
                    us.DesactivarError();
                    request.getRequestDispatcher("Exito.jsp").forward(request, response);
                } else {
                    us.DesactivarError();
                    us.ErrorValidacionUsuario();
                    request.getRequestDispatcher("Login_Registrar.jsp").forward(request, response);
                }   break;
            case "true":
                us.setNuevo_Usuario(true);
                request.getRequestDispatcher("Login_Registrar.jsp").forward(request, response);
                break;
            case "nuevo":
                // en caso se quera registrar un nuevo usuario
                us.setNombre(request.getParameter("txtNombre1"));
                String pass = request.getParameter("txt1");
                String pass1 = request.getParameter("txt2");
                if (pass.equals(pass1)) {
                    us.setPassworld(pass1);
                    boolean Exito =Mi_ConexionDB.AgregarUsuario(us);
                    us.DesactivarError();
                    if (Exito) {
                         us.ActivatUsuario();
                         request.getRequestDispatcher("Exito.jsp").forward(request, response);
                    }
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                } else {
                    us.ErrorRegistracionUsuario();
                    request.getRequestDispatcher("Login_Registrar.jsp").forward(request, response);
                }   break;
            default:
                request.getRequestDispatcher("Error.jsp").forward(request, response);
                break;
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
