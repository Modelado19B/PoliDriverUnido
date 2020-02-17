/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ALEX
 */
public class DATOS_DISPONIBILIDAD {

    private String costo;
    private String disponiblidad;
    private String Parada;
    private String CostoParada;

    public String getParada() {
        return Parada;
    }

    public void setParada(String Parada) {
        this.Parada = Parada;
    }

    public String getCostoParada() {
        return CostoParada;
    }

    public void setCostoParada(String CostoParada) {
        this.CostoParada = CostoParada;
    }

    public String getDisponiblidad() {
        return disponiblidad;
    }

    public void setDisponiblidad(String disponiblidad) {
        this.disponiblidad = disponiblidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "DATOS_DISPONIBILIDAD{" + "costo=" + costo + ", disponiblidad=" + disponiblidad + ", Parada=" + Parada + ", CostoParada=" + CostoParada + '}';
    }

 

}
