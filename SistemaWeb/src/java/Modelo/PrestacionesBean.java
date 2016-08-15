package Modelo;

import java.util.ArrayList;

public class PrestacionesBean {

    private String Id;
    private String Horas_trabajadas;
    private String Tarifa;
    private final double AFP = 2.72;
    private String Mes;
    private String Year;
    private double Total;
    private String Estado;
    private ArrayList<String> Error;

    public PrestacionesBean() {
        this.Id = "";
        this.Horas_trabajadas = "";
        this.Tarifa = "";
        this.Mes = "";
        this.Year = "";
        this.Total = 0;
        this.Estado = "NO_PAGADA";
        Error = new ArrayList<String>();
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getHoras_trabajadas() {
        return Horas_trabajadas;
    }

    public void setHoras_trabajadas(String Horas_trabajadas) {
        this.Horas_trabajadas = Horas_trabajadas;
    }

    public String getTarifa() {
        return Tarifa;
    }

    public void setTarifa(String Tarifa) {
        this.Tarifa = Tarifa;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getTotal() {
        double horas = Double.parseDouble(Horas_trabajadas);
        double tarifa = Double.parseDouble(Tarifa);
        Total = horas * tarifa;
        double descuento = (Total / 100) * AFP;
        Total = Total - descuento;
        return String.valueOf(Total);
    }

    public String getAFP() {
        return String.valueOf(AFP);
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public boolean ValidarPrestacion() {
        boolean Valido = true;
        if (Id.isEmpty()) {
            Error.add("Es obligatorio Seleccionar el Id");
            Valido = false;
        }
        if (Horas_trabajadas.isEmpty()) {
            Error.add("Es obligatorio introducir las horas trabajadas");
            Valido = false;
        }
        if (Tarifa.isEmpty()) {
            Error.add("Es obligatorio introducir la tarifa por hora");
            Valido = false;
        }
        if (Year.isEmpty()) {
            Error.add("Es obligatorio introducir el año");
            Valido = false;
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
