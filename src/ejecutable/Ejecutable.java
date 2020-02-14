package ejecutable;


import modelo.ARCHIVOS_PLANOS;
import modelo.Genera_Cuenta;
import modelo.PAGO_VIAJE;
import modelo.PASAJERO;
import vistas.FORMULARIO_PAGO;
import vistas.*;


public class Ejecutable {
    
    public static void main(String[] args) {

//      ARCHIVOS_PLANOS obj = new ARCHIVOS_PLANOS();       
//      obj.leerArchivo("172526388-1");
        PRINCIPAL p = new PRINCIPAL();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
       
//        FORMULARIO_PAGO dialog = new FORMULARIO_PAGO(new javax.swing.JFrame(), true);
 //       Genera_Cuenta gc = new Genera_Cuenta();
 //       PASAJERO pasajero= gc.generaDatosPasajero("012345678-9");
//        dialog.setDatos(pasajero, 20, "144444444-4");
//        dialog.setVisible(true);

        PAGO_VIAJE pg = new PAGO_VIAJE();
        System.out.println("si: "+pg.pagar(pasajero, 20, "144444444-4"));
        
        
        System.exit(0);
    }
    
}
