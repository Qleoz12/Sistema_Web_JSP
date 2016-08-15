/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadisticasBean {

    private String Numero_Usuario;
    private String Numero_Empleados;
    private String Numero_Prestaciones;
    private String Numero_Prestaciones_Pagadas;
    private String Numero_Prestaciones_Proceso;
    private Conexion_DB Conexion;

    public EstadisticasBean() {
        this.Numero_Usuario = "";
        this.Numero_Empleados = "";
        this.Numero_Prestaciones = "";
        this.Numero_Prestaciones_Proceso = "";
        this.Numero_Prestaciones_Pagadas = "";
        this.Conexion = new Conexion_DB();
    }

    public String getNumero_Usuario() {
        Connection conexion = Conexion.getConexion();
        List<String> array = new ArrayList<String>();
        try {
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("select * from USUARIO");
            while (rs.next()) {
                array.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Numero_Usuario = array.size() + "";
        return Numero_Usuario;
    }

    public void setNumero_Usuario(String Numero_Usuario) {
        this.Numero_Usuario = Numero_Usuario;
    }

    public String getNumero_Empleados() {
        Connection conexion = Conexion.getConexion();
        List<String> array = new ArrayList<String>();
        try {
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("select * from EMPLEADO");
            while (rs.next()) {
                array.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Numero_Empleados = array.size() + "";
        Conexion.Desconectar();

        return Numero_Empleados;
    }

    public void setNumero_Empleados(String Numero_Empleados) {
        this.Numero_Empleados = Numero_Empleados;
    }

    public String getNumero_Prestaciones() {
        Connection conexion = Conexion.getConexion();
        List<String> array = new ArrayList<String>();
        try {
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("select * from PRESTACIONES");
            while (rs.next()) {
                array.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Numero_Prestaciones = array.size() + "";
        Conexion.Desconectar();

        return Numero_Prestaciones;
    }

    public void setNumero_Prestaciones(String Numero_Prestaciones) {
        this.Numero_Prestaciones = Numero_Prestaciones;
    }

    public String getNumero_Prestaciones_Pagadas() {
        Connection conexion = Conexion.getConexion();
        List<String> array = new ArrayList<String>();
        try {
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("select * from PRESTACIONES where ESTADO = 'PAGADO'");
            while (rs.next()) {
                array.add(rs.getString(1));
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Numero_Prestaciones_Pagadas = array.size() + "";
        Conexion.Desconectar();
        return Numero_Prestaciones_Pagadas;
    }

    public void setNumero_Prestaciones_Pagadas(String Numero_Prestaciones_Pagadas) {
        this.Numero_Prestaciones_Pagadas = Numero_Prestaciones_Pagadas;
    }

    public String getNumero_Prestaciones_Proceso() {
        Connection conexion = Conexion.getConexion();
        List<String> array = new ArrayList<String>();
        try {
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("select * from PRESTACIONES where ESTADO = 'NO_PAGADA'");
            while (rs.next()) {
                array.add(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Numero_Prestaciones_Proceso = array.size() + "";
        Conexion.Desconectar();
        return Numero_Prestaciones_Proceso;
    }

    public void setNumero_Prestaciones_Proceso(String Numero_Prestaciones_Proceso) {
        this.Numero_Prestaciones_Proceso = Numero_Prestaciones_Proceso;
    }

    public Conexion_DB getConexion() {
        return Conexion;
    }

    public void setConexion(Conexion_DB Conexion) {
        this.Conexion = Conexion;
    }

}
