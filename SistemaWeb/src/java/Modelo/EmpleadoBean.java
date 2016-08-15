package Modelo;

import java.util.ArrayList;

public class EmpleadoBean {

    private String Id;
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Sexo;
    private String Fecha_Nacimineto;
    private String Direccion;
    private String Telefono;
    private String Email;
    private ArrayList<String> Error;
    private boolean Buscar;

    public EmpleadoBean() {
        this.Id = "";
        this.Cedula = "";
        this.Nombre = "";
        this.Apellido = "";
        this.Sexo = "";
        this.Fecha_Nacimineto = "";
        this.Direccion = "";
        this.Telefono = "";
        this.Email = "";
        this.Error = new ArrayList<String>();
        this.Buscar = false;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getFecha_Nacimineto() {
        return Fecha_Nacimineto;
    }

    public void setFecha_Nacimineto(String Fecha_Nacimineto) {
        this.Fecha_Nacimineto = Fecha_Nacimineto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean getBuscar() {
        return Buscar;
    }

    public void setBuscar(boolean Buscar) {
        this.Buscar = Buscar;
    }

    public boolean ValidarEmpleado() {
        boolean Valido = true;
        if (Id.isEmpty()) {
            Valido = false;
            Error.add("El Id del empleado es oblidatorio");
        }
        if (Cedula.isEmpty()) {
            Valido = false;
            Error.add("La cedula del empleado es oblidatoria");
        }
        if (Nombre.isEmpty()) {
            Valido = false;
            Error.add("El nombre del Empleado es oblidatorio");
        }
        if (Apellido.isEmpty()) {
            Valido = false;
            Error.add("El apellido del Empleado es oblidatorio");
        }
        if (Fecha_Nacimineto.isEmpty()) {
            Valido = false;
            Error.add("La fecha nacimineto del Empleado es oblidatorio");
        }
        if (Sexo.isEmpty()) {
            Valido = false;
            Error.add("Es oblidatorio definir el sexo del empleado");
        }
        if (Direccion.isEmpty()) {
            Valido = false;
            Error.add("La direccion del Empleado es oblidatoria");
        }
        if (Telefono.isEmpty()) {
            Valido = false;
            Error.add("El numero de telefono del Empleado es oblidatorio");
        }
        if (Email.isEmpty()) {
            Valido = false;
            Error.add("la email del Empleado es oblidatoria");
        }
        return Valido;
    }

    public void LimpiarErrores() {
        Error.clear();
    }
    public ArrayList<String> getErrores(){
    return Error;
    }

}
