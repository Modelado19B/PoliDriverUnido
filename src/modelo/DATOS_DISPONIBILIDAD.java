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
               
        return "DATOS_DISPONIBILIDAD{" + "\ncosto=" + costo + ", \ndisponiblidad=" + disponiblidad + '}';
    }

}
