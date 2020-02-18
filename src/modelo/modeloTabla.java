/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author david
 */
public class modeloTabla {
    String viaje;
    String cedula;
    String numero;

    public modeloTabla(String dato1, String dato2, String dato3) {
        this.viaje = dato1;
        this.cedula = dato2;
        this.numero = dato3;
    }

    public String getViaje() {
        return viaje;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNumero() {
        return numero;
    }
    

    @Override
    public String toString() {
        return viaje + "++" + cedula + "++" + numero;
    }
       
}
