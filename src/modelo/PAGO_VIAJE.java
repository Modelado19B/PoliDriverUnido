package modelo;

import javax.swing.JOptionPane;
import vistas.FORMULARIO_PAGO;

public class PAGO_VIAJE extends PAGO {

    private String numCuentaEmpresa = getNumCuentaEmpresa();

    public boolean pagar(PASAJERO pasajero, int montoString, String cedulaConductor) {
        Genera_Cuenta gc = new Genera_Cuenta();
        formulario = new FORMULARIO_PAGO(new javax.swing.JFrame(), true);
        formulario.setDatos(pasajero, montoString);
        formulario.setVisible(true);
        String cvv = formulario.getCvv();
        formulario.dispose();
        boolean estado = false;
        
        if (cvv.equals("")) {
            JOptionPane.showMessageDialog(formulario, "Se canceló el Pago");
            return estado;
        } else {
            int monto = montoString;

            String numCuentaConductor = gc.genNumTarjetaCedula(cedulaConductor);
            String numCuentaPasajero = gc.genNumTarjetaCedula(pasajero.getCedula());

            float montoEmpresa = monto * 2 / 10;
            float montoConductor = monto * 8 / 10;

            if (debitar_cuenta(numCuentaPasajero, cvv, monto)) {
                if (acreditar_cuenta(numCuentaConductor, montoConductor)) {
                    acreditar_cuenta(numCuentaEmpresa, montoEmpresa);
                    estado = true;
                } else {
                    System.out.println("Error en el depósito del conductor.");
                }
            } else {
                System.out.println("Error en el débito del pasajero.");
            }
            if (estado) {
                JOptionPane.showMessageDialog(formulario, "El Pago fue realizado corectamente");
            }
            return estado;
        }
    }

}
