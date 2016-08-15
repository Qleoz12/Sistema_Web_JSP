
package Modelo;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion_DB {

    private Connection Conexion;
    private PreparedStatement PreStat;
    private String queryValidaUsuario = "select * from USUARIO where NOMBRE = ? and PASSWORLD = ?";
    private String queryBuscarEmpleado = "select ID, CEDULA, NOMBRE, APELLIDO from EMPLEADO where ID=?";

    public Connection getConexion() {
        Connection mi_Conexion = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            mi_Conexion = DriverManager.getConnection("jdbc:sqlserver://JOSEEDUARDO-PC\\SQLSERVER:1433;databaseName=SISTEMA_WEB", "JOSEEDUARDO-PC", "sqlserver1");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mi_Conexion;
    }

    public boolean ValidarUsuario(UsuarioBean user) {
        boolean Valido = false;
        Conexion = getConexion();
        try {
            PreStat = Conexion.prepareCall(queryValidaUsuario);
            PreStat.setString(1, user.getNombre());
            PreStat.setString(2, user.getPassworld());
            ResultSet rs = PreStat.executeQuery();
            while (rs.next()) {
                Valido = true;
            }
            Desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Valido;

    }

    public void Desconectar() {
        Conexion = null;
    }

    public boolean AgregarUsuario(UsuarioBean us) {
        boolean Error = true;
        Conexion = getConexion();
        try {
            Statement st = Conexion.createStatement();
            st.executeUpdate("insert into USUARIO values('" + us.getNombre() + "','" + us.getPassworld() + "' )");
            Desconectar();
        } catch (SQLException ex) {
            return false;
        }

        return Error;
    }

    public Boolean AgregarEmpleado(EmpleadoBean emple) {
        boolean Exito = true;
        Conexion = getConexion();
        try {
            Statement st = Conexion.createStatement();
            st.executeUpdate("insert into EMPLEADO values('" + emple.getId() + "','" + emple.getCedula() + "','" + emple.getNombre() + "', '" + emple.getApellido() + "'"
                    + ",'" + emple.getFecha_Nacimineto() + "','" + emple.getSexo() + "', '" + emple.getDireccion() + "','" + emple.getTelefono() + "', '" + emple.getEmail() + "' )");
            Desconectar();
        } catch (SQLException ex) {
            return false;
        }
        return Exito;
    }

    public ArrayList<EmpleadoBean> getLista_Empleados() {
        ArrayList<EmpleadoBean> lista = new ArrayList<EmpleadoBean>();
        Conexion = getConexion();
        EmpleadoBean emple;
        try {
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from EMPLEADO");
            while (rs.next()) {
                emple = new EmpleadoBean();
                emple.setId(rs.getString(1));
                emple.setCedula(rs.getString(2));
                emple.setNombre(rs.getString(3));
                emple.setApellido(rs.getString(4));
                emple.setFecha_Nacimineto(rs.getString(5));
                emple.setSexo(rs.getString(6));
                emple.setDireccion(rs.getString(7));
                emple.setTelefono(rs.getString(8));
                emple.setEmail(rs.getString(9));
                lista.add(emple);
            }
            Desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public EmpleadoBean BuscarEmpleado(String ID) {
        EmpleadoBean Mi_Empleado = new EmpleadoBean();
        Conexion = getConexion();
        try {
            PreStat = Conexion.prepareCall(queryBuscarEmpleado);
            PreStat.setString(1, ID);
            ResultSet rs = PreStat.executeQuery();
            while (rs.next()) {
                Mi_Empleado.setId(rs.getString(1));
                Mi_Empleado.setCedula(rs.getString(2));
                Mi_Empleado.setNombre(rs.getString(3));
                Mi_Empleado.setApellido(rs.getString(4));
            }
            Desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Mi_Empleado;
    }

    public Boolean AgregarPrestacion(PrestacionesBean presta) {
        boolean Exito = true;
        Conexion = getConexion();
        try {
            Statement st = Conexion.createStatement();
            st.executeUpdate("insert into PRESTACIONES values('" + presta.getId() + "','" + presta.getHoras_trabajadas() + "','" + presta.getTarifa() + "',"
                    + "'" + presta.getAFP() + "','" + presta.getMes() + "','" + presta.getYear() + "','" + presta.getTotal() + "','" + presta.getEstado() + "')");
            Desconectar();
        } catch (SQLException ex) {
            return false;
        }
        return Exito;
    }

    public ArrayList<PrestacionesBean> getListaPrestaciones() {
        ArrayList<PrestacionesBean> lista = new ArrayList<PrestacionesBean>();
        Conexion = getConexion();
        PrestacionesBean presta;
        try {
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from PRESTACIONES");
            while (rs.next()) {
                presta = new PrestacionesBean();
                presta.setId(rs.getString(1));
                presta.setHoras_trabajadas(rs.getString(2));
                presta.setTarifa(rs.getString(3));
                presta.setMes(rs.getString(5));
                presta.setYear(rs.getString(6));
                presta.setEstado(rs.getString(8));
                lista.add(presta);
            }
            Desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    public boolean PagarPrestacion(String Id){
    boolean Exito = true;
    Conexion = getConexion();
    Statement stat;
        try {
            stat = Conexion.createStatement(); 
            stat.executeUpdate("UPDATE PRESTACIONES SET ESTADO = 'PAGADO' WHERE ID='"+Id+"'");
            
        } catch (SQLException ex) {
          Exito = false;
        }
        Desconectar();
    return Exito;
    }
}
