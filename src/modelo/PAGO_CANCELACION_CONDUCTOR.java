/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author d
 */
public class PAGO_CANCELACION_CONDUCTOR extends PAGO {

    private String numCuentaEmpresa = getNumCuentaEmpresa();
    

    public boolean pagar(String cedulaPasajero, String cedulaConductor, float monto) {

        Genera_Cuenta gc= new Genera_Cuenta();
        String numCuentaConductor = gc.genNumCuenta(cedulaConductor);
        String numCuentaPasajero = gc.genNumCuenta(cedulaPasajero);         
        
        float montoEmpresa = monto * 2 / 10;
        float montoConductor = monto * 8 / 10;

        boolean estado = false;

        if (debitar_cuenta(numCuentaConductor, montoConductor)) {
            if (debitar_cuenta(numCuentaEmpresa, montoEmpresa)) {
                if (acreditar_cuenta(numCuentaPasajero, monto)) {
                    System.out.println("Cancelacion Correcta");
                    estado = true;
                } else {
                    System.out.println("Error de cancelacion por pasajero");
                    acreditar_cuenta(numCuentaConductor, montoConductor);
                    acreditar_cuenta(numCuentaEmpresa, montoEmpresa);
                }
            }
        } else {
            System.out.println("Error cuenra de conductor");
        }
        
        if(estado){
            JOptionPane.showMessageDialog(formulario, "Cancelación correcta");
            notifica_cancelacion_exitosa();
        }
        return estado;
    }

}
