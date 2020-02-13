package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DATOS_DEL_VIAJE {

    private String lugar_origen;
    private String lugar_destino;
    private Date fecha;
    private String hora_salida;
    private String hora_llegada;
    private String indiceViaje, conductor, apellidoConductor, ci_conductor, auto, placa;
    private int total_asientos, total_asientos_disponibles, precio;

    public DATOS_DEL_VIAJE(String indiceViaje, String ci_conductor, String conductor, String apellidoConductor, int total_asientos, String auto, String placa, String origen, String destino, Date fecha, String horaSalida, String horaLlegada, int precio, int disponibles) {
        this.indiceViaje = indiceViaje;
        this.lugar_origen = origen;
        this.lugar_destino = destino;
        this.fecha = fecha;
        this.total_asientos = total_asientos;
        this.total_asientos_disponibles = disponibles;
        this.precio = precio;
        this.conductor = conductor;
        this.apellidoConductor = apellidoConductor;
        this.ci_conductor = ci_conductor;
        this.auto = auto;
        this.placa = placa;
        this.hora_llegada = horaLlegada;
        this.hora_salida = horaSalida;
    }

    public DATOS_DEL_VIAJE() {

    }

    public Date fechaClase() {
        return this.fecha;
    }
    public String getFecha() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        return sd.format(this.fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIndiceViaje() {
        return indiceViaje;
    }

    public void setIndiceViaje(String indiceViaje) {
        this.indiceViaje = indiceViaje;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getApellidoConductor() {
        return apellidoConductor;
    }

    public void setApellidoConductor(String apellidoConductor) {
        this.apellidoConductor = apellidoConductor;
    }

    public String getCi_conductor() {
        return ci_conductor;
    }

    public void setCi_conductor(String ci_conductor) {
        this.ci_conductor = ci_conductor;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTotal_asientos() {
        return total_asientos;
    }

    public void setTotal_asientos(int total_asientos) {
        this.total_asientos = total_asientos;
    }

    public int getTotal_asientos_disponibles() {
        return total_asientos_disponibles;
    }

    public void setTotal_asientos_disponibles(int total_asientos_disponibles) {
        this.total_asientos_disponibles = total_asientos_disponibles;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getLugar_origen() {
        return lugar_origen;
    }

    public void setLugar_origen(String lugar_origen) {
        this.lugar_origen = lugar_origen;
    }

    public String getLugar_destino() {
        return lugar_destino;
    }

    public void setLugar_destino(String lugar_destino) {
        this.lugar_destino = lugar_destino;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    @Override
    public String toString() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        return this.indiceViaje + "++" +this.ci_conductor + "++"  + this.conductor + "++" + this.apellidoConductor + "++" + this.total_asientos_disponibles + "++" + this.auto
                + "++" + this.placa + "++" + this.lugar_origen +  "++" + this.lugar_destino + "++" + sd.format(this.fecha)
                + "++" + this.hora_salida + "++" + this.hora_llegada + "++" + this.precio +"++" + this.total_asientos_disponibles + "++" + "{}";
    }  

    public void setFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
