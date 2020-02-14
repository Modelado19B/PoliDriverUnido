package modelo;

import vistas.FORMULARIO_PAGO;

public class PAGO_VIAJE extends PAGO {

    private String numCuentaEmpresa = getNumCuentaEmpresa();

    public boolean pagar(String nomConductor, String cedulaPasajero, int montoString, String Cvv) {

//        formulario = new FORMULARIO_PAGO(new javax.swing.JFrame(), true);
//        
//        formulario.setVisible(true);        
//        String cvv = formulario.getCvv();
//        formulario.dispose();
        Genera_Cuenta gc = new Genera_Cuenta();

        int monto = montoString;

        String numCuentaConductor = gc.genNumTarjetaCedula(nomConductor);
        String numCuentaPasajero = gc.genNumTarjetaCedula(cedulaPasajero);

        float montoEmpresa = monto * 2 / 10;
        float montoConductor = monto * 8 / 10;

        boolean estado = false;
        if (debitar_cuenta(numCuentaPasajero, Cvv, monto)) {
            if (acreditar_cuenta(numCuentaConductor, montoConductor)) {
                acreditar_cuenta(numCuentaEmpresa, montoEmpresa);
                estado = true;
            } else {
                System.out.println("Error en el depósito del conductor.");
            }

        } else {
            System.out.println("Error en el débito del pasajero.");
        }
        return estado;
    }

    public boolean pagar(PASAJERO pasajero, int montoString, String cedulaConductor) {
        //PASAJERO pasajero, int precio, String nombre
        Genera_Cuenta gc = new Genera_Cuenta();
        formulario = new FORMULARIO_PAGO(new javax.swing.JFrame(), true);
        formulario.setDatos(pasajero, montoString);
        formulario.setVisible(true);
        String cvv = formulario.getCvv();
        formulario.dispose();

        int monto = montoString;

        String numCuentaConductor = gc.genNumTarjetaCedula(cedulaConductor);
        String numCuentaPasajero = gc.genNumTarjetaCedula(pasajero.getCedula());

        float montoEmpresa = monto * 2 / 10;
        float montoConductor = monto * 8 / 10;

        boolean estado = false;
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
        return estado;
    }

}
