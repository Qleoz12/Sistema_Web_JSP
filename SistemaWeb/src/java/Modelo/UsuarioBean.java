/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class UsuarioBean {

    private String Nombre;
    private String Passworld;
    private String Error;
    private boolean Nuevo_Usuario;
    private boolean UsuarioAttivo;

    public UsuarioBean() {
        this.Nombre = "";
        this.Passworld = "";
        this.Error = "false";
        this.Nuevo_Usuario = false;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPassworld() {
        return Passworld;
    }

    public void setPassworld(String Passworld) {
        this.Passworld = Passworld;
    }

    public void ErrorValidacionUsuario() {
        Error = "true";
    }
       public void ErrorRegistracionUsuario() {
        Error = "regtrue";
    }

    public String getError() {
        return Error;
    }

    public void DesactivarError() {
        this.Error = "false";
    }

    public boolean isNuevo_Usuario() {
        return Nuevo_Usuario;
    }

    public void setNuevo_Usuario(boolean v) {
        this.Nuevo_Usuario = v;
    }
    public void ActivatUsuario(){
    this.UsuarioAttivo = true;
    }
    public void DesactivarUsuario(){
    this.UsuarioAttivo = false;
    }
    public boolean getEstado(){
    return UsuarioAttivo;
    }

}
