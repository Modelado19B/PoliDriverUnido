package controlador;

import modelo.DATOS_DEL_VIAJE;

public class Nodo {

    private DATOS_DEL_VIAJE viaje;
    private Nodo enlace;

    public Nodo() {
        this.viaje = new DATOS_DEL_VIAJE();
        this.enlace = new Nodo();
    }

    public Nodo(DATOS_DEL_VIAJE viaje) {
        this.viaje = viaje;
        this.enlace = null;
    }

    public Nodo(DATOS_DEL_VIAJE viaje, Nodo enlace) {
        this.viaje = viaje;
        this.enlace = enlace;
    }

    public DATOS_DEL_VIAJE getViaje() {
        return viaje;
    }

    public void setVIaje(DATOS_DEL_VIAJE viaje) {
        this.viaje = viaje;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

}
