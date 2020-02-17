package ejecutable;


import modelo.ARCHIVOS_PLANOS;
import vistas.FORMULARIO_VIAJE1;
import vistas.PRINCIPAL;


public class Ejecutable {
    
    public static void main(String[] args) {

//      ARCHIVOS_PLANOS obj = new ARCHIVOS_PLANOS();       
//      obj.leerArchivo("172526388-1");
        FORMULARIO_VIAJE1 p = new FORMULARIO_VIAJE1();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
      
    }
    
}
